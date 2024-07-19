import { useState } from "react";
import { DatePicker, LocalizationProvider } from '@mui/x-date-pickers';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs'

const AddPlannedAttractionForm = ({ postPlannedAttraction, attractionId, itineraries, attractionName }) => {

  const [selectedItinerary, setSelectedItinerary] = useState(null);
  const [selectedItineraryName, setSelectedItineraryName] = useState("");
  const [startTime, setStartTime] = useState(null);
  const [endTime, setEndTime] = useState(null);
  const [newItineraryName, setNewItineraryName] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
    if (handleValidation()) {

      const plannedAttraction = {
        itineraryId: selectedItinerary ? selectedItinerary.id : null,
        attractionId,
        startTime: startTime.format('DD/MM/YYYY'),
        endTime: endTime ? endTime.format('DD/MM/YYYY') : startTime.format('DD/MM/YYYY'),
        itineraryName: newItineraryName
      }

      postPlannedAttraction(plannedAttraction);
    }
  }

  const handleValidation = () => {

    if (!selectedItinerary && newItineraryName.trim() === "") {
      alert("Please select existing itinerary or enter name for new itinerary")
      return false;
    }

    if (startTime === null) {
      alert("Please set dates.")
      return false;
    }

    if (startTime.isAfter(endTime)) {
      alert("Selected start date is after selected end date.");
      return false;
    }

    return true;
  }

  const handleItineraryChange = (event) => {
    setSelectedItineraryName(event.target.value);
    setSelectedItinerary(itineraries.find(itinerary => itinerary.name === event.target.value));
  }

  return (
    <div className="flex mx-3 flex-col items-center justify-center">
    <div className="bg-gray-100 mx-3 flex rounded-2xl shadow-lg max-w-3xl w-full h-auto">
      <div className="w-full p-12 flex flex-col justify-center">
        <h1 className="font-bold text-xl text-center text-indigo-400 mb-6">Add {attractionName} to Itinerary!</h1>

        <form className="flex flex-col gap-4" onSubmit={handleSubmit}>
          <div className="input-box relative w-full mb-6">
            <label className="block mb-2">Itinerary:</label>
            <select 
              className="p-2 rounded-xl border w-full text-black"
              value={selectedItineraryName}
              onChange={handleItineraryChange}
            >
              <option value="">Create New Itinerary</option>
              {itineraries.map(itinerary => (
                <option key={itinerary.id} value={itinerary.name}>{itinerary.name}</option>
              ))}
            </select>
          </div>

          {!selectedItinerary && (
            <div className="input-box relative w-full mb-6">
              <label className="block mb-2">New Itinerary Name:</label>
              <input
                className="p-2 rounded-xl border w-full text-black"
                name="itinerary-name"
                placeholder="Enter name of new itinerary"
                value={newItineraryName}
                onChange={e => setNewItineraryName(e.target.value)}
              />
            </div>
          )}

          <div className="input-box relative w-full mb-6">
            <label className="block mb-2">Start Date</label>
            <LocalizationProvider dateAdapter={AdapterDayjs}>
              <DatePicker
                value={startTime}
                onChange={value => setStartTime(value)}
                renderInput={(params) => <input {...params} className="p-2 rounded-xl border w-full text-black" />}
              />
            </LocalizationProvider>
          </div>

          {startTime && (
            <div className="input-box relative w-full mb-6">
              <label className="block mb-2">End Date</label>
              <LocalizationProvider dateAdapter={AdapterDayjs}>
                <DatePicker
                  value={endTime === null ? startTime : endTime}
                  onChange={value => setEndTime(value)}
                  renderInput={(params) => <input {...params} className="p-2 rounded-xl border w-full text-black" />}
                />
              </LocalizationProvider>
            </div>
          )}

          <div className="flex justify-center">
            <button
              className="bg-indigo-400 p-2 px-10 rounded-xl text-white py-2 hover:scale-105 duration-300"
              type="submit"
            >
              Add
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
  );
};

export default AddPlannedAttractionForm;
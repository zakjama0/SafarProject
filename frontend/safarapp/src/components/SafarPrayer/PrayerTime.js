import React, { useState, useEffect } from 'react';
import { getPrayerData } from '../SafarPrayer/prayerApiIndex';
import { TextField } from '@mui/material';

function PrayerTime() {
    const [times, setTimes] = useState({});
    const [city, setCity] = useState('Brisbane');
    const [country, setCountry] = useState('Australia');
    const [searchParams, setSearchParams] = useState({ city: 'London', country: 'England' });

    useEffect(() => {
        getPrayerData(searchParams.city, searchParams.country).then((data) => {
            if (data && data.data && data.data.timings) {
                console.log('Returned Data:', data.data.timings);
                setTimes(data.data.timings);
            }
        }).catch(error => {
            console.error('Error fetching data:', error);
        });
    }, [searchParams]);

    const handleSearch = () => {
        setSearchParams({ city, country });
    };

    return (
        <>
            
            <div className='flex flex-col items-center '>
                <div className=''>
                <label className="block dark:text-white text-gray-700 text-sm font-bold " htmlFor="city">
          Enter City
        </label>
        <input
          className="my-2 p-2 border dark:text-black rounded-lg w-full focus:outline-none focus:ring-2 focus:ring-indigo-400"
          id="city"
          type="text"
          placeholder="Enter City"
          value={city}
          onChange={(e) => setCity(e.target.value)}
        />
                </div>
            
               
                <div className=''>
                <label className="block text-gray-700 dark:text-white text-sm font-bold" htmlFor="country">
          Enter Country
        </label>
        <input
          className="my-2 p-2 border dark:text-black rounded-lg w-full focus:outline-none focus:ring-2 focus:ring-indigo-400"
          id="country"
          type="text"
          placeholder="Enter Country"
          value={country}
          onChange={(e) => setCountry(e.target.value)}
        />
                </div>
                
                <button className='py-2 px-3 border text-white rounded-md bg-gradient-to-r from-blue-500 to-blue-800 dark:text-white' onClick={handleSearch}>Get Prayer Times</button>
            </div>
            <h1 className='mb-3 text-xl text-bold text-center '>Prayer Times for {searchParams.city}, {searchParams.country}:</h1>
            <div className="overflow-y-auto max-h-96 grid grid-cols-1 gap-4 text-center">
                {Object.keys(times).length > 0 && (
                    <>
                        <div className="p-4 bg-white rounded-md shadow-md">
                            <h3 className="text-xl font-semibold text-gray-700">Fajr</h3>
                            <p className="text-lg text-gray-600">{times.Fajr}</p>
                        </div>
                        <div className="p-4 bg-white rounded-md shadow-md">
                            <h3 className="text-xl font-semibold text-gray-700">Dhuhr</h3>
                            <p className="text-lg text-gray-600">{times.Dhuhr}</p>
                        </div>
                        <div className="p-4 bg-white rounded-md shadow-md">
                            <h3 className="text-xl font-semibold text-gray-700">Asr</h3>
                            <p className="text-lg text-gray-600">{times.Asr}</p>
                        </div>
                        <div className="p-4 bg-white rounded-md shadow-md">
                            <h3 className="text-xl font-semibold text-gray-700">Maghrib</h3>
                            <p className="text-lg text-gray-600">{times.Maghrib}</p>
                        </div>
                        <div className="p-4 bg-white rounded-md shadow-md">
                            <h3 className="text-xl font-semibold text-gray-700">Isha</h3>
                            <p className="text-lg text-gray-600">{times.Isha}</p>
                        </div>
                        <div className="p-4 bg-white rounded-md shadow-md">
                            <h3 className="text-xl font-semibold text-gray-700">Last third of the night</h3>
                            <p className="text-lg text-gray-600">{times.Lastthird}</p>
                        </div>
                    </>
                )}
            </div>
        </>
    );
}

export default PrayerTime;

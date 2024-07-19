import React, { useState, useEffect } from 'react';
import { CssBaseline, Grid, Box, Tabs, Tab, Typography, Drawer, useMediaQuery, useTheme } from '@mui/material';
import Search from '../components/SafarMap/Header/Search';
import List from '../components/SafarMap/List/List';
import Map from '../components/SafarMap/Maps/Map';
import { getPlacesData } from '../components/SafarMap/apiIndex';
import PropTypes from 'prop-types';
import { styled } from '@mui/material/styles';
import PrayerTime from '../components/SafarPrayer/PrayerTime';

const CustomTab = styled((props) => <Tab disableRipple {...props} />)(({ theme }) => ({
  textTransform: 'none',
  minWidth: 0,
  [theme.breakpoints.up('sm')]: {
    minWidth: 0,
  },
  fontWeight: theme.typography.fontWeightRegular,
  marginRight: theme.spacing(1),
  color: 'rgba(0, 0, 0, 0.85)',
  fontFamily: [
    "Montserrat",
    'sans-serif',
  ].join(','),
  '&:hover': {
    color: '#40a9ff',
    opacity: 1,
  },
  '&.Mui-selected': {
    color: '#1890ff',
    fontWeight: theme.typography.fontWeightMedium,
  },
  '&.Mui-focusVisible': {
    backgroundColor: '#d1eaff',
  },
}));

function CustomTabPanel(props) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`simple-tabpanel-${index}`}
      aria-labelledby={`simple-tab-${index}`}
      {...other}
    >
      {value === index && (
        <Box sx={{ p: 3 }}>
          <Typography>{children}</Typography>
        </Box>
      )}
    </div>
  );
}

CustomTabPanel.propTypes = {
  children: PropTypes.node,
  index: PropTypes.number.isRequired,
  value: PropTypes.number.isRequired,
};

function a11yProps(index) {
  return {
    id: `simple-tab-${index}`,
    'aria-controls': `simple-tabpanel-${index}`,
  };
}

const MapsContainer = () => {
  const [value, setValue] = useState(0);
  const [places, setPlaces] = useState([]);
  const [bounds, setBounds] = useState(null);
  const [filteredPlaces, setFilteredPlaces] = useState([]);
  const [childClicked, setChildClicked] = useState(null);
  const [coordinates, setCoordinates] = useState([]);
  const [category, setCategory] = useState("TRAVEL_DUA");
  const [isLoading, setIsLoading] = useState(false);
  const [open, setOpen] = useState(false);
  const [rating, setRating] = useState('');

  const theme = useTheme();
  const isMobile = useMediaQuery(theme.breakpoints.down('sm'));

  useEffect(() => {
    navigator.geolocation.getCurrentPosition(({ coords: { latitude, longitude } }) => {
      setCoordinates({ lat: latitude, lng: longitude });
    });
  }, []);

  useEffect(() => {
    setIsLoading(true);
    getPlacesData({ coordinates }).then((data) => {
      setPlaces(data.results);
      setFilteredPlaces([])
      setIsLoading(false);
    });
  }, [coordinates]);
  // useEffect(() => {
  //   // Fetch places data from an API or use static data
  //   // Example: setPlaces(yourData);

  //   // Update filtered places when bounds change
  //   if (bounds) {
  //     const filtered = places.filter((place) =>
  //       place.geometry.location.lat >= bounds.sw.lat &&
  //       place.geometry.location.lat <= bounds.ne.lat &&
  //       place.geometry.location.lng >= bounds.sw.lng &&
  //       place.geometry.location.lng <= bounds.ne.lng
  //     );
  //     setFilteredPlaces(filtered);
  //   }
  // }, [bounds, places]);


  useEffect (() => {
    const filteredPlaces = places.filter(place => place.rating> rating)
    setFilteredPlaces(filteredPlaces)
  }, [rating])

  const handleTabChange = (event, newValue) => {
    setValue(newValue);
    setCategory(valueToCategory[newValue]);
    if (isMobile) {
      setOpen(true);
    }
  };

  const handleClose = () => {
    setOpen(false);
  };

  const [isModalOpen, setIsModalOpen] = useState(false);

  const toggleModal = () => {
    setIsModalOpen(!isModalOpen);
  };

  const valueToCategory = {
    0: "TRAVEL_DUA",
    1: "TRAVEL_ETIQUETTE",
  };

  return (
    <div className='h-full min-h-screen bg-[#d2dbd8] dark:bg-slate-800 dark:text-white w-full'>
      <CssBaseline />
      <div>
        
      </div>

      <Grid container spacing={3} style={{ width: '100%' }}>
        <Grid item xs={12} md={4} style={{ display: isMobile ? 'none' : 'block' }}>
          <div className='h-full'>
            <Box>
              <Tabs className='mx-auto' sx={{ width: 4 / 5 }} value={value} onChange={handleTabChange} variant='fullWidth' aria-label="basic tabs example">
                <CustomTab label="Food" {...a11yProps(0)} className='dark:text-white' />
                <CustomTab label="Masjids" {...a11yProps(1)} className='dark:text-white' />
                <CustomTab label="Prayer Time" {...a11yProps(2)} className='dark:text-white' />
              </Tabs>
            </Box>
            <CustomTabPanel value={value} index={0}>
            <Search setCoordinates={setCoordinates} />
              <List 
                places={filteredPlaces.length ? filteredPlaces: places} 
                childClicked={childClicked}
                isLoading={isLoading}
              />
            </CustomTabPanel>
            <CustomTabPanel value={value} index={1}>
            <h1>Not available in Beta</h1>
            </CustomTabPanel>
            <CustomTabPanel value={value} index={2}>
              <PrayerTime />
            </CustomTabPanel>
          </div>
        </Grid>
        <Grid item xs={12} md={8}>
          <div className='mt-6'>

         
          <Box
            sx={{
              width: '100%',
              height: '100%',
              '@media (min-width: 600px)': {
                height: '100%',
              },
              borderRadius: '10px',
              overflow: 'hidden',
              boxShadow: 3,
              marginLeft: '10px',
            }}
          >
            <Map 
              setCoordinates={setCoordinates}
              coordinates={coordinates}
              setChildClicked={setChildClicked}
              places={filteredPlaces.length ? filteredPlaces: places}
              setBounds={setBounds}
            />
          </Box>
          </div>
        </Grid>
      </Grid>

      {/* Drawer for mobile view */}
      {isMobile && (
        
          <div>
         <div className="App flex items-center justify-center ">
      <div
        className={`fixed bottom-0 left-1/2 transform -translate-x-1/2 z-50 cursor-pointer px-10 bg-white text-black rounded-t-lg ${isModalOpen ? 'hidden' : 'block'}`}
        onClick={toggleModal}
      >
        <span className="text-4xl font-bold">▲</span>
      </div>
     
      <div
      className={`fixed inset-0 z-50 flex items-end transition-opacity duration-300 ${isModalOpen ? 'opacity-100 pointer-events-auto' : 'opacity-0 pointer-events-none'}`}
    >
      <div className="fixed inset-0 bg-black opacity-50" onClick={toggleModal}></div>
      <div
        className={`bg-white rounded-t-lg w-full p-5 transform transition-transform duration-300 ${isModalOpen ? 'translate-y-0' : 'translate-y-full'}`}
        onClick={(e) => e.stopPropagation()}
      >
        <span className="text-2xl font-bold cursor-pointer" onClick={toggleModal}>
          &times;
        </span>
        <Box>
              <Tabs className='mx-auto' sx={{ width: 4 / 5 }} value={value} onChange={handleTabChange} variant='fullWidth' aria-label="basic tabs example">
                <CustomTab label="Food" {...a11yProps(0)} className='dark:text-white' />
                <CustomTab label="Masjids" {...a11yProps(1)} className='dark:text-white' />
                <CustomTab label="Prayer Time" {...a11yProps(2)} className='dark:text-white' />
              </Tabs>
            </Box>
            <CustomTabPanel value={value} index={0}>
            <Search setCoordinates={setCoordinates} />
              <List 
                places={filteredPlaces.length ? filteredPlaces: places} 
                childClicked={childClicked}
                isLoading={isLoading}
              />
            </CustomTabPanel>
            <CustomTabPanel value={value} index={1}>
            <div className='py-60 text-center'>Not Available In Beta</div>
            </CustomTabPanel>
            <CustomTabPanel value={value} index={2}>
              <PrayerTime />
            </CustomTabPanel>
      </div>
    </div>
    </div>
        {/* </Drawer> */}
        </div>
      )}
    </div>
  );
};

export default MapsContainer;


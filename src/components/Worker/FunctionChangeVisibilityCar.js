import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useLocation, useNavigate } from 'react-router-dom';
import {
  Button,
  Box,
  AppBar,
  Toolbar,
} from "@mui/material";

function FunctionChangeVisibilityCar() {
  const location = useLocation();
  const navigate = useNavigate();

  const carChangeVisibility = async () => {
    return await axios.put("http://localhost:8081/car/changeVisibilityCar", {
      id: location.state.idCar
    }).then((response) => {
      console.log("ok");
    }).catch((err) => {
      console.error(err)
    })
  };

  useEffect(() => {
    carChangeVisibility();
  }, [])

  return (
    <div>
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static">
          <Toolbar variant="dense">
          </Toolbar>
        </AppBar>
      </Box>
      <Button
        onClick={(event) => {
          navigate("/allcarofworker", {
            state: { idCar: location.state.idCar, idWorker: location.state.idWorker },
          });
        }}
      >
        Back to the list of cars
      </Button>
    </div>
  )
}

export default FunctionChangeVisibilityCar;
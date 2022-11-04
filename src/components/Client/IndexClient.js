import React, { useEffect, useState } from "react";
import CarAvalible from "../Car/CarAvalible";
import { useLocation } from "react-router-dom";
import axios from "axios";
import {
  Box,
  AppBar,
  Toolbar,
  Typography,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
} from "@mui/material";

function Index() {
  const location = useLocation();

  const [car, setCar] = useState([]);
  const [nameUser, setNameUser] = useState("");
  const [totCarRental, setTotCarRental] = useState(0);
  const [totCarRentalBoolean, setTotCarRentalBoolean] = useState(false);

  const countTotCarRentalByIdClient = () => {
    axios
      .post("http://localhost:8081/client/getIdByEmail", {
        email: location.state.email,
      })
      .then((response) => {
        axios
          .post("http://localhost:8081/car/countTotCarRentalByIdClient", {
            id: response.data.id,
          })
          .then((response) => {
            setTotCarRental(response.data);
            if (totCarRental.count === 0) {
              setTotCarRentalBoolean(false);
            } else {
              setTotCarRentalBoolean(true);
            }
          })
          .catch((err) => {
            console.error(err);
          });
      })
      .catch((err) => {
        console.error(err);
      });
  };

  function printNameUser() {
    axios
      .post("http://localhost:8081/client/getNameByEmail", {
        email: location.state.email,
      })
      .then((response) => setNameUser(response.data.name));
  }

  const getCarOfClient = async () => {
    countTotCarRentalByIdClient();
    printNameUser();
    return await axios
      .post("http://localhost:8081/client/getIdByEmail", {
        email: location.state.email,
      })
      .then((response) => {
        axios
          .post("http://localhost:8081/car/viewCarsOfClient", {
            id: response.data.id,
          })
          .then((response) => {
            setCar(response.data.c);
          })
          .catch((err) => {
            console.error(err);
          })
          .catch((err) => {
            console.error(err);
          });
      })
      .catch((err) => {
        console.error(err);
      });
  };

  useEffect(() => {
    getCarOfClient();
  }, []);

  function tableTotCar() {
    return (
      <div>
        <Typography variant="h4" color={"inherit"} component="div">
          There is not cars accuty rental of {nameUser}
        </Typography>
      </div>
    );
  }

  return (
    <>
      <div>
        <Box sx={{ flexGrow: 1 }}>
          <AppBar position="static">
            <Toolbar variant="dense">
              <Typography variant="h4" color={"inherit"} component="div">
                Welcome {nameUser}
              </Typography>
            </Toolbar>
          </AppBar>
        </Box>
        {!totCarRentalBoolean && tableTotCar()}
        {totCarRentalBoolean && (
          <Box>
            <Typography
              variant="h4"
              color={"inherit"}
              component="div"
              align="center"
            >
              Cars accutly rental of {nameUser}
            </Typography>
            <TableContainer component={Paper}>
              <Table sx={{ minWidth: 650 }} aria-label="simple table">
                <TableHead>
                  <TableRow>
                    <TableCell align="center">Model</TableCell>
                    <TableCell align="center">Brand</TableCell>
                    <TableCell align="center">Color</TableCell>
                    <TableCell align="center">Money daily</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {car.map((car) => (
                    <TableRow key={car.id}>
                      <TableCell align="center">
                        <div>{car.model}</div>
                      </TableCell>
                      <TableCell align="center">
                        <div>{car.brand}</div>
                      </TableCell>
                      <TableCell align="center">
                        <div>{car.color}</div>
                      </TableCell>
                      <TableCell align="center">
                        <div>{car.moneyDaily}</div>
                      </TableCell>
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            </TableContainer>
          </Box>
        )}
        <Box marginBottom={4}></Box>
        <CarAvalible props={location.state.email}></CarAvalible>
      </div>
    </>
  );
}

export default Index;

import React, { useEffect, useState } from "react";
import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";
import {
  Box,
  Grid,
  AppBar,
  Toolbar,
  Typography,
  Button,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  Stack,
} from "@mui/material";

function AllCarOfWorker() {
  const navigate = useNavigate();
  const location = useLocation();

  const isAvailable = "Is available for the rental";
  const isNotAvailable = "Is not available for the rental";

  const isRental = "Is rental";
  const isNotRental = "Is not rental";

  const [emailWorker, setEmailWorker] = useState("");
  const [loading, setLoading] = useState(true);
  const [cars, setCars] = useState([]);
  const [name, setName] = useState("");

  const objIdWorker = location.state.idWorker;
  let idInput = Number(Object.values(objIdWorker)[0]);

  const getCar = async () => {
    return await axios
      .post("http://localhost:8081/car/viewCarOfWorker", {
        id: idInput,
      })
      .then((response) => {
        setLoading(true);
        setCars(response.data.c);
      })
      .catch((err) => {
        console.error(err);
        setLoading(false);
      });
  };

  const getEmail = () => {
    axios
      .post("http://localhost:8081/worker/getEmailById", {
        id: idInput,
      })
      .then((response) => {
        let valueJSONEmail = JSON.stringify(response.data);
        let parseJSONEmail = JSON.parse(valueJSONEmail);
        setEmailWorker(parseJSONEmail.email);
      })
      .catch((err) => {
        console.error(err);
      });
  };

  const getName = () => {
    axios
      .post("http://localhost:8081/worker/getNameById", {
        id: idInput,
      })
      .then((response) => {
        let valueJSON = JSON.stringify(response.data);
        let parseJSON = JSON.parse(valueJSON);
        setName(parseJSON.name);
      })
      .catch((err) => {
        console.error(err);
      });
  };

  useEffect(() => {
    getCar();
    getName();
    getEmail();
  }, []);

  return (
    <>
      <div>
        <Box sx={{ flexGrow: 1 }}>
          <AppBar position="static">
            <Toolbar variant="dense">
              <Typography variant="h4" color={"inherit"} component="div">
                {name}'s car manage
              </Typography>
            </Toolbar>
          </AppBar>
        </Box>
        <TableContainer component={Paper}>
          <Table sx={{ minWidth: 650 }} aria-label="simple table">
            <TableHead>
              <TableRow>
                <TableCell align="center">Model</TableCell>
                <TableCell align="center">Brand</TableCell>
                <TableCell align="center">Color</TableCell>
                <TableCell align="center">Money daily</TableCell>
                <TableCell align="center">Status of Available</TableCell>
                <TableCell align="center">Change visibilty</TableCell>
                <TableCell align="center">Rental car</TableCell>
              </TableRow>
            </TableHead>
            {loading && (
              <TableBody>
                {cars.map((car) => (
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
                    <TableCell align="center">
                      {car.available ? isAvailable : isNotAvailable}
                    </TableCell>
                    <TableCell align="center">
                      {car.rental ? isRental : isNotRental}
                    </TableCell>
                    <TableCell align="center">
                      <Stack spacing={2} direction="row">
                        <Button
                          variant="contained"
                          onClick={() =>
                            navigate("/changeVisibilty", {
                              state: {
                                idCar: car.id,
                                isRental: car.rental,
                                idWorker: location.state.idWorker,
                              },
                            })
                          }
                        >
                          Change visibility
                        </Button>
                      </Stack>
                    </TableCell>
                  </TableRow>
                ))}
              </TableBody>
            )}
          </Table>
        </TableContainer>
          <Box
            margin={2}
          >
          <Grid container justifyContent={"flex-end"}>
            <Grid item>
              <Button
                size="small"
                color="primary"
                onClick={() =>
                  navigate("/indexWorker", {
                    state: { email: emailWorker },
                  })
                }
              >
                Back to home {name}
              </Button>
            </Grid>
          </Grid>
          <Grid container justifyContent={"flex-end"}>
            <Grid item>
              <Button
                size="small"
                color="primary"
                onClick={() =>
                  navigate("/addcar", {
                    state: { idWorker: location.state.idWorker },
                  })
                }
              >
                Add car
              </Button>
            </Grid>
          </Grid>
          </Box>
        </div>
    </>
  );
}

export default AllCarOfWorker;

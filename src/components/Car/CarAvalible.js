import React, { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import {
  Box,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Button,
  Typography,
} from "@mui/material";

function CarAvalible(props) {
  const navigate = useNavigate();

  const [cars, setCars] = useState([]);
  const [totCar, setTotCar] = useState(0);
  const [totCarBoolean, setTotCarBoolean] = useState(false);

  const countTotCarAvailable = () => {
    axios
      .get("http://localhost:8081/car/countTotCarAvailable")
      .then((response) => {
        setTotCar(response.data.count);
        if (totCar.count === 0) {
          setTotCarBoolean(false);
        } else {
          setTotCarBoolean(true);
        }
      })
      .catch((err) => {
        console.error(err);
      });
  };

  const getCar = async () => {
    return await axios
      .get("http://localhost:8081/car/viewCarAvailable")
      .then((response) => {
        setCars(response.data.c);
      })
      .catch((err) => {
        console.error(err);
      });
  };

  useEffect(() => {
    getCar();
    countTotCarAvailable();
  }, []);

  function printTotCarNumber() {
    return (
      <div>
        <Box
          sx={{
            marginTop: 8,
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
          }}
        >
          <Typography
            variant="h4"
            color={"inherit"}
            component="div"
            align="center"
          >
            There is not car for the rental
            <br />
            <Button onClick={() => navigate("/")}>Logout</Button>
          </Typography>
        </Box>
      </div>
    );
  }

  return (
    <>
      <div>
        {!totCarBoolean && printTotCarNumber()}
        {totCarBoolean && (
          <>
            <Box
              sx={{
                marginTop: 8,
                display: "flex",
                flexDirection: "column",
                alignItems: "center",
              }}
            >
              <Typography variant="h4" color={"inherit"} component="div">
                Car available for the rental
              </Typography>
              <TableContainer>
                <Table>
                  <TableHead>
                    <TableRow>
                      <TableCell align="center">Model</TableCell>
                      <TableCell align="center">Brand</TableCell>
                      <TableCell align="center">Color</TableCell>
                      <TableCell align="center">Money daily</TableCell>
                    </TableRow>
                  </TableHead>
                  <TableBody>
                    {cars.map((car) => (
                      <TableRow key={car.id}>
                        <TableCell align="center">
                          <div>{car.model}</div>
                        </TableCell>
                        <TableCell>
                          <div>{car.brand}</div>
                        </TableCell>
                        <TableCell>
                          <div>{car.color}</div>
                        </TableCell>
                        <TableCell>
                          <div>{car.moneyDaily}</div>
                        </TableCell>
                        <TableCell>
                          <Button
                            variant="contained"
                            onClick={() =>
                              navigate("/rental", {
                                state: { email: props, idCar: car.id },
                              })
                            }
                          >
                            Rental car
                          </Button>
                        </TableCell>
                      </TableRow>
                    ))}
                  </TableBody>
                </Table>
              </TableContainer>
            </Box>
          </>
        )}
      </div>
    </>
  );
}

export default CarAvalible;

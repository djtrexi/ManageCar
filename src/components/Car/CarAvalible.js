import React, { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import {
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
        setTotCar(response.data);
        if(totCar === 0){
          setTotCarBoolean(false);
        }
        else{
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
        <Typography variant="h4" color={"inherit"} component="div">
          There is not car for the rental
        </Typography>
      </div>
    );
  };

  return (
    <>
      <div>
        {totCarBoolean && printTotCarNumber()}
        {!totCarBoolean && (
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
        )}
      </div>
    </>
  );
}

export default CarAvalible;

import axios from "axios";
import React, { useState, useEffect } from "react";
import {
  Box,
  Button,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Typography,
} from "@mui/material";
import { useNavigate } from "react-router-dom";

function FinishPayment() {
  const navigate = useNavigate();

  const [bills, setBills] = useState([]);
  const [name, setName] = useState("");
  const [surname, setSurname] = useState("");
  const [brand, setBrand] = useState("");
  const [nameWorker, setNameWorker] = useState("");
  const [surnameWorker, setSurnameWorker] = useState("");
  
  const getBills = async () => {
    return await axios
      .get("http://localhost:8081/bill/billNotFinish")
      .then((response) => {
        setBills(response.data.c);
      })
      .catch((err) => {
        console.error(err);
      });
  };

  const getNameAndSurname = (idClient) => {
    axios
      .post("http://localhost:8081/client/byObjectGetId", {
        id: idClient,
      })
      .then((response) => {
        setName(response.data.name);
        setSurname(response.data.surname);
      }).catch((err) => {
        console.error(err);
      })
  };

  const getBrandCar = (idCar) => {
    axios.post("http://localhost:8081/car/getBrandCarById", {
      id: idCar,
    }).then((response) => {
      setBrand(response.data.brand);
    }).catch((err) => {
      console.error(err);
    })
  };

  const getNameAndSurnameWorker = (idWorker) => {
    axios.post("http://localhost:8081/worker/getObjectByIdRequest", {
      id: idWorker,
    }).then((response) => {
      setNameWorker(response.data.name);
      setSurnameWorker(response.data.surname);
    }).catch((err) => {
      console.log(err);
    });
  };

  const setFinishPayment = (idBill) => {
    axios.put("http://localhost:8081/bill/finishThePayment", {
      id: idBill,
    }).then((response) => {

    }).catch((err) => {
      console.error(err);
    })
  };
  
  useEffect(() => {
    getBills();
  }, []);

  return (
    <>
      <div>
        <Box sx={{ mt:2 }}></Box>
          <Typography variant="subtitle1" align="center" color={"inherit"} component="div">
            Car rental, but miss the payment
          </Typography>
          <TableContainer>
            <Table>
              <TableHead>
                <TableRow>
                  <TableCell align="center">Client</TableCell>
                  <TableCell align="center">Car</TableCell>
                  <TableCell align="center">Worker</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {bills.map((bill) => (
                  <TableRow key={bill.id}>
                    <TableCell align="center">
                      {getNameAndSurname(bill.idClient)}
                      <div>{name} {surname}</div>
                    </TableCell>
                    <TableCell>
                      {getBrandCar(bill.idCar)}
                      <div>{brand}</div>
                    </TableCell>
                    <TableCell>
                      {getNameAndSurnameWorker(bill.idWorker)}
                      <div>{nameWorker} {surnameWorker}</div>
                    </TableCell>
                    <TableCell>
                      <Button
                        variant="contained"
                        fullWidth
                        sx={{ mt: 3, mb: 2 }}                
                        onClick={() => {
                          setFinishPayment(bill.id);
                        }}
                      >
                        Finish the payment
                      </Button>
                    </TableCell>
                  </TableRow>
                ))}
              </TableBody>
            </Table>
          </TableContainer>
      </div>
    </>
  );
}

export default FinishPayment;

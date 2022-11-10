import axios from "axios";
import React, { useState } from "react";
import {
  AppBar,
  Box,
  Button,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Toolbar,
  Typography,
  Paper,
} from "@mui/material";
import { useLocation, useNavigate } from "react-router-dom";

function FinishPayment() {
  const navigate = useNavigate();
  const location = useLocation();

  const [bills, setBills] = useState([]);
  const [name, setName] = useState("");
  const [surname, setSurname] = useState("");
  const [brand, setBrand] = useState("");
  const [nameWorker, setNameWorker] = useState("");
  const [surnameWorker, setSurnameWorker] = useState("");
  const [completePay, setCompletePay] = useState(false);
  const [totBillsBoolean, setTotBillsBoolean] = useState(false);

  const getBills = () => {
    axios
      .get("http://localhost:8081/bill/billNotFinish")
      .then((response) => {
        setBills(response.data.c);
        if (bills.length === 0) {
          setTotBillsBoolean(true);
        } else {
          setTotBillsBoolean(false);
        }
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
      })
      .catch((err) => {
        console.error(err);
      });
  };

  const getBrandCar = (idCar) => {
    axios
      .post("http://localhost:8081/car/getBrandCarById", {
        id: idCar,
      })
      .then((response) => {
        setBrand(response.data.brand);
      })
      .catch((err) => {
        console.error(err);
      });
  };

  const getNameAndSurnameWorker = (idWorker) => {
    axios
      .post("http://localhost:8081/worker/getObjectByIdRequest", {
        id: idWorker,
      })
      .then((response) => {
        setNameWorker(response.data.name);
        setSurnameWorker(response.data.surname);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const setFinishPayment = (idBill) => {
    axios
      .put("http://localhost:8081/bill/finishThePayment", {
        id: idBill,
      })
      .then((response) => {
        setCompletePay(true);
        if (completePay) {
          alert("Order complete!!!");
        }
      })
      .catch((err) => {
        setCompletePay(false);
        alert("ERROR...");
        console.error(err);
      });
  };

  getBills();

  function printButtonReturnHome() {
    return (
      <div>
        <Box sx={{ flexGrow: 1 }}>
          <AppBar position="static">
            <Toolbar variant="dense">
              <Typography variant="h4" color="inherit" component="div">
                Bill
              </Typography>
            </Toolbar>
          </AppBar>
        </Box>
        <Box
          sx={{
            display: "flex",
            flexDirection: { xs: "column", md: "row" },
            alignItems: "center",
            justifyContent: "center",
            margin: 2,
          }}
        >
          <Button
            sx={{ mt: 2 }}
            variant="contained"
            align="center"
            onClick={() =>
              navigate("/indexWorker", {
                state: { email: location.state.email },
              })
            }
          >
            Back home worker
          </Button>
        </Box>
      </div>
    );
  }

  return (
    <>
      <div>
        {totBillsBoolean && printButtonReturnHome()}
        {!totBillsBoolean && (
          <>
            <Box sx={{ flexGrow: 1 }}>
              <AppBar position="static">
                <Toolbar variant="dense">
                  <Typography variant="h4" color="inherit" component="div">
                    Bill
                  </Typography>
                </Toolbar>
              </AppBar>
            </Box>
            <Box sx={{ marginTop: 2, marginBottom: 2 }}>
              <Typography
                align="center"
                variant="h4"
                color={"inherit"}
                component="div"
              >
                Bill not complete
              </Typography>
            </Box>
            <TableContainer component={Paper}>
              <Table sx={{ minWidth: 650 }} aria-label="simple table">
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
                        <div>
                          {name} {surname}
                        </div>
                      </TableCell>
                      <TableCell align="center">
                        {getBrandCar(bill.idCar)}
                        <div>{brand}</div>
                      </TableCell>
                      <TableCell align="center">
                        {getNameAndSurnameWorker(bill.idWorker)}
                        <div>
                          {nameWorker} {surnameWorker}
                        </div>
                      </TableCell>
                      <TableCell align="center">
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
          </>
        )}
      </div>
    </>
  );
}

export default FinishPayment;

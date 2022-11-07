import React, { useEffect, useState } from "react";
import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";
import {
  Box,
  AppBar,
  Toolbar,
  Typography,
  Stack,
  CssBaseline,
  TextField,
  Button,
} from "@mui/material";
import { Container } from "@mui/system";
import { DatePicker, LocalizationProvider } from "@mui/x-date-pickers";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";

function StartTheRental() {
  const location = useLocation();
  const navigate = useNavigate();

  var today = new Date();
  var date =
    today.getFullYear() + "-" + (today.getMonth() + 1) + "-" + today.getDate();

  const [dateBegin, setDateBegin] = useState(new Date(date));
  const [dateFinish, setDateFinish] = useState(new Date(date));
  const [brandCar, setBrandCar] = useState("");

  const objEmailUser = location.state.email;
  let emailInput = String(Object.values(objEmailUser)[0]);

  console.log(location.state);

  const getNameCar = async () => {
    return await axios
      .post("http://localhost:8081/car/getBrandCarById", {
        id: location.state.idCar,
      })
      .then((response) => {
        let valueJSON = JSON.stringify(response.data);
        let parseJSON = JSON.parse(valueJSON);
        setBrandCar(parseJSON.brand);
      })
      .catch((err) => {
        console.error(err);
      });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    axios
      .post("http://localhost:8081/client/getIdByEmail", {
        email: emailInput,
      })
      .then((response) => {
        axios
          .put("http://localhost:8081/car/rentalCar", {
            idCar: location.state.idCar,
            idClient: response.data.id,
            dateBegin: dateBegin,
            dateFinish: dateFinish,
          })
          .then((response) => {
            navigate("/order", {
              state: {
                idCar: location.state.idCar,
                email: location.state.email,
              },
            });
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
    getNameCar();
  }, []);

  return (
    <div>
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static">
          <Toolbar variant="dense">
            <Typography variant="h4" color={"inherit"} component="div">
              Information for the rental <>{brandCar}</>
            </Typography>
          </Toolbar>
        </AppBar>
      </Box>
      <Container component={"main"} maxWidth="xs">
        <CssBaseline />
        <Box
          sx={{
            marginTop: 8,
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
          }}
        >
          <Typography sx={{ mb: 2 }} variant="subtitle1">
            Insert the dates for the period of rental
          </Typography>
          <Box
            component={"form"}
            noValidate
            sx={{ mt: 1 }}
            onSubmit={handleSubmit}
          >
            <LocalizationProvider dateAdapter={AdapterDayjs}>
              <Stack spacing={3}>
                <DatePicker
                  label="Date start rental"
                  renderInput={(params) => <TextField {...params} />}
                  value={dateBegin}
                  onChange={(event) => {
                    setDateBegin(event);
                  }}
                  minDate={today}
                  required
                />
                <DatePicker
                  label="Date finish rental"
                  renderInput={(params) => <TextField {...params} />}
                  value={dateFinish}
                  onChange={(event) => {
                    setDateFinish(event);
                  }}
                  minDate={today}
                  required
                />
              </Stack>
            </LocalizationProvider>
            <Button
              variant="contained"
              fullWidth
              sx={{ mt: 3, mb: 2 }}
              type={"submit"}
            >
              Start the rental
            </Button>
          </Box>
        </Box>
      </Container>
    </div>
  );
}

export default StartTheRental;

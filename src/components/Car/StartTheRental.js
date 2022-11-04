import React from "react";
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
import { LocalizationProvider } from "@mui/x-date-pickers";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import dayjs from "dayjs";
import { DesktopDatePicker } from "@mui/x-date-pickers/DesktopDatePicker";

function StartTheRental() {
  const location = useLocation();
  const navigate = useNavigate();

  var today = new Date();
  let day = String(today.getDate()).padStart(2, "0");
  let month = String(today.getMonth() + 1).padStart(2, "0");
  let year = today.getFullYear();
  today = year + "/" + month + "/" + day;

  const [dateBegin, setDateBegin] = React.useState(dayjs());
  const [dateFinish, setDateFinish] = React.useState(dayjs());

  const objEmailUser = location.state.email;
  let emailInput = String(Object.values(objEmailUser)[0]);

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
            navigate("/order", {state: { idCar: location.state.idCar, email: location.state.email }});
          })
          .catch((err) => {
            console.error(err);
          });
      })
      .catch((err) => {
        console.error(err);
      });
  };

  return (
    <div>
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static">
          <Toolbar variant="dense">
            <Typography variant="h4" color={"inherit"} component="div">
              Information for the rental
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
                <DesktopDatePicker
                  required
                  minDate={today}
                  label="Date begin rental"
                  inputFormat="YYYY/MM/DD"
                  value={dateBegin}
                  onChange={(event) => {
                    setDateBegin(dateBegin);
                  }}
                  renderInput={(params) => <TextField {...params} />}
                />
                <DesktopDatePicker
                  required
                  minDate={dateBegin}
                  label="Date finish rental"
                  inputFormat="YYYY/MM/DD"
                  value={dateFinish}
                  onChange={(event) => {
                    setDateFinish(dateFinish);
                  }}
                  renderInput={(params) => <TextField {...params} />}
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

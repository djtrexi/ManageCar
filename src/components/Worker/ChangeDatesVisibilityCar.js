import axios from "axios";
import React, { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import {
  Box,
  AppBar,
  Toolbar,
  Container,
  CssBaseline,
  Grid,
  Stack,
  Button,
  TextField,
} from "@mui/material";
import { LocalizationProvider, DatePicker } from "@mui/x-date-pickers";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";

function ChangeDatesVisibilityCar() {
  const location = useLocation();
  const navigate = useNavigate();

  var today = new Date();
  var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();

  const objIdWorker = location.state.idWorker;
  let idInput = Number(Object.values(objIdWorker)[0]);

  const [nameWorker, setNameWorker] = useState("");
  const [date_available_finish, setAvalableFinish] = useState(new Date(date));
  const [date_available_start, setAvalableStart] = useState(new Date(date));

  const getName = async () => {
    return await axios
      .post("http://localhost:8081/worker/getNameById", {
        id: idInput,
      })
      .then((response) => {
        let valueJSON = JSON.stringify(response.data);
        let parseJSON = JSON.parse(valueJSON);
        setNameWorker(parseJSON.name);
      })
      .catch((err) => {
        console.error(err);
      });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    axios
      .put("http://localhost:8081/car/checkVisibilityCarDate", {
        id: location.state.idCar,
        dateAvailableStart: date_available_start,
        dateAvailableFinish: date_available_finish,
      })
      .then((response) => {
        navigate("/allcarofworker", {
          state: {
            idCar: location.state.idCar,
            idWorker: location.state.idWorker,
          },
        });
      })
      .catch((err) => {
        console.error(err);
      });
  };

  useEffect(() => {
    getName();
  }, []);

  return (
    <div>
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static">
          <Toolbar variant="dense"></Toolbar>
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
          <Box
            component={"form"}
            noValidate
            sx={{ mt: 1 }}
            onSubmit={handleSubmit}
          >
            <Grid marginBottom={3} />
            <LocalizationProvider dateAdapter={AdapterDayjs}>
              <Stack spacing={3}>
                <DatePicker
                  label="Date available start"
                  minDate={date}
                  renderInput={(params) => <TextField {...params} />}
                  value={date_available_start}
                  onChange={(event) => {
                    setAvalableStart(event);
                  }}
                  required
                />
                <DatePicker
                  label="Date available finish"
                  minDate={date_available_start}
                  renderInput={(params) => <TextField {...params} />}
                  value={date_available_finish}
                  onChange={(event) => {
                    setAvalableFinish(event);
                  }}
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
              Update days
            </Button>
            <Grid container justifyContent={"flex-end"}>
              <Grid item>
                <Button
                  onClick={() =>
                    navigate("/allcarofworker", {
                      state: {
                        idWorker: location.state.idWorker,
                        idCar: location.state.idCar,
                      },
                    })
                  }
                >
                  Back to list cars <>{nameWorker.toString()}</>
                </Button>
              </Grid>
            </Grid>
          </Box>
        </Box>
      </Container>
    </div>
  );
}

export default ChangeDatesVisibilityCar;

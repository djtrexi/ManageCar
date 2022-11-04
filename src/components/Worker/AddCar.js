import React, { useEffect, useState } from "react";
import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";
import TextField from "@mui/material/TextField";
import {
  Grid,
  Box,
  AppBar,
  Toolbar,
  Typography,
  CssBaseline,
  Button,
} from "@mui/material";
import { Container, Stack } from "@mui/system";
import { DatePicker, LocalizationProvider } from "@mui/x-date-pickers";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";

function AddCar() {
  const location = useLocation();
  const navigate = useNavigate();

  var today = new Date();
  var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();

  const [emailWorker, setEmailWorker] = useState("");
  const [nameWorker, setNameWorker] = useState("");
  const [brand, setBrand] = useState("");
  const [color, setColor] = useState("");
  const [annoProduzione, setAnnoProduzione] = useState(new Date(date));
  const [date_available_finish, setAvalableFinish] = useState(new Date());
  const [date_available_start, setAvalableStart] = useState(new Date());
  const [model, setModel] = useState("");
  const [moneyDaily, setMoneyDaily] = useState(0.0);
  const [numberCar, setNumberCar] = useState("");

  const handleModel = (event) => {
    setModel(event.target.value);
  };

  const handleColor = (event) => {
    setColor(event.target.value);
  };

  const handleMoneyDaily = (event) => {
    setMoneyDaily(event.target.value);
  };

  const handleNumberCar = (event) => {
    setNumberCar(event.target.value);
  };

  const handleBrand = (event) => {
    setBrand(event.target.value);
  };

  const objIdWorker = location.state.idWorker;
  let idInput = Number(Object.values(objIdWorker)[0]);

  const handleSubmit = (event) => {
    event.preventDefault();
    axios
      .post("http://localhost:8081/car/addCar", {
        model: model,
        brand: brand,
        color: color,
        numberCar: numberCar,
        annoProduzione: annoProduzione,
        dateAvalableStart: date_available_start,
        dateAvalableFinish: date_available_finish,
        moneyDaily: moneyDaily,
        idWorker: idInput,
      })
      .then((response) => {
        navigate("/allcarofworker", {
          state: { idWorker: location.state.idWorker },
        });
      })
      .catch((err) => {
        console.error(err);
      });
  };

  useEffect(() => {
    async function getNameAndEmailWorker() {
      await axios.post("http://localhost:8081/worker/getNameById", {
        id: idInput
      }).then((response) => {
          let valueJSON = JSON.stringify(response.data);
          let parseJSON = JSON.parse(valueJSON);
          setNameWorker(parseJSON.name);
          axios.post("http://localhost:8081/worker/getEmailById", {
            id : idInput
          }).then((response) => {
            let valueJSONEmail = JSON.stringify(response.data);
            let parseJSONEmail = JSON.parse(valueJSONEmail);
            setEmailWorker(parseJSONEmail.email);
          }).catch((err) => {
            console.error(err);
          })
      }).catch((err) => {
        console.error(err);
      })
    };
    getNameAndEmailWorker();
  }, []);

  return (
    <>
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static">
          <Toolbar variant="dense">
            <Typography variant="h4" color={"inherit"} component="div">
              Add car
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
          <Box
            component={"form"}
            noValidate
            sx={{ mt: 1 }}
            onSubmit={handleSubmit}
          >
            <Grid container spacing={2}>
              <Grid item xs={12} sm={6}>
                <TextField
                  fullWidth
                  id="standard-textarea"
                  label="Model"
                  placeholder="Model car"
                  multiline
                  variant="standard"
                  type={"text"}
                  value={model}
                  onChange={handleModel}
                  required
                  name="model"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  fullWidth
                  id="standard-textarea"
                  label="Brand"
                  placeholder="Brand car"
                  multiline
                  variant="standard"
                  type={"text"}
                  value={brand}
                  onChange={handleBrand}
                  required
                  name="brand"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  fullWidth
                  id="standard-textarea"
                  label="Color"
                  placeholder="Color car"
                  multiline
                  variant="standard"
                  type={"text"}
                  value={color}
                  onChange={handleColor}
                  required
                  name="color"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  fullWidth
                  id="standard-textarea"
                  label="Number car"
                  placeholder="Number car"
                  multiline
                  variant="standard"
                  type={"text"}
                  maxLength={"7"}
                  value={numberCar}
                  onChange={handleNumberCar}
                  required
                  name="numberCar"
                />
              </Grid>
            </Grid>
            <Grid
              container
              spacing={0}
              direction="column"
              alignItems="center"
              justifyContent="center"
              style={{ minHeight: "50vh" }}
            >
              <Grid item xs={3}>
                <TextField
                  label="Money daily"
                  id="outlined-basic"
                  variant="outlined"
                  value={moneyDaily}
                  onChange={handleMoneyDaily}
                  required
                  name="moneyDaily"
                  InputProps={{
                    inputProps: {
                      type: "number",
                      min: 0.0,
                      step: 0.1,
                    },
                  }}
                />
              </Grid>
              <Grid marginBottom={3} />
              <LocalizationProvider dateAdapter={AdapterDayjs}>
                <Stack spacing={3}>
                  <DatePicker
                    label='Prodution year'
                    renderInput={(params) => <TextField {...params} />}
                    value={annoProduzione}
                    onChange={(event) => {
                      setAnnoProduzione(event)
                    }}
                    required
                  />
                  <DatePicker
                    label='Date available start'
                    renderInput={(params) => <TextField {...params} />}
                    value={date_available_start}
                    onChange={(event) => {
                      setAvalableStart(event);
                    }}
                    required
                  />
                  <DatePicker
                    label='Date available finish'
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
                Add car
              </Button>
            </Grid>
            <Grid container justifyContent={"flex-end"}>
              <Grid item>
                <Button onClick={() => navigate("/allcarofworker", {
                                        state: { idWorker: idInput }
                                      })
                                }
                >
                  View car of {nameWorker}
                </Button>
              </Grid>
            </Grid>
            <Grid container justifyContent={"flex-end"}>
              <Grid item>
                <Button onClick={() => navigate("/indexWorker", {
                                        state: { email: emailWorker }
                                      })
                                }
                >
                  Back to home
                </Button>
              </Grid>
            </Grid>
          </Box>
        </Box>
      </Container>
    </>
  );
}

export default AddCar;

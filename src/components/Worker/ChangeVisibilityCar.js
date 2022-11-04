import {
  Button,
  Box,
  AppBar,
  Toolbar,
  Typography,
  CssBaseline,
  Dialog,
  DialogTitle,
  DialogContent,
  DialogContentText,
  DialogActions,
} from "@mui/material";
import { Container } from "@mui/system";
import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";

function ChangeVisibilityCar() {
  const navigate = useNavigate();
  const location = useLocation();

  const [openDelete, setOpenDelete] = useState(false);
  const [openVisibility, setOpenVisibility] = useState(false);
  const [changeVisibilityCar, setChangeVisibilityCar] = useState(false);
  const [brandCar, setBrandCar] = useState("");

  const getCar = async () => {
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

  useEffect(() => {
    getCar();
  }, []);

  const handleClickOpenDelete = () => {
    setOpenDelete(true);
  };

  const handleClickCloseDelete = () => {
    setOpenDelete(false);
  };

  const handleClickOpenVisibility = () => {
    setOpenVisibility(true);
  };

  const handleClickCloseVisibility = () => {
    setOpenVisibility(false);
  };

  const handleClickOpenChangeVisibilityCar = () => {
    setChangeVisibilityCar(true);
  };

  const handleClickCloseChangeVisibilityCar = () => {
    setChangeVisibilityCar(false);
  };

  function isRental() {
    return (
      <div>
        <Box sx={{ flexGrow: 1 }}>
          <AppBar position="static">
            <Toolbar variant="dense">
              <Typography variant="h4" color={"inherit"} component="div">
                ERROR 404
              </Typography>
            </Toolbar>
          </AppBar>
        </Box>
        <Container component={"main"} maxWidth="xs">
          <CssBaseline />
          <Box
            sx={{
              display: "flex",
              flexDirection: { xs: "column", md: "row" },
              alignItems: "center",
              justifyContent: "center",
              margin: 2,
            }}
          >
            <Typography variant="h1" color={"inherit"} component="div">
              This car is rental, so you can't do modify
            </Typography>
          </Box>
        </Container>
      </div>
    );
  }

  return (
    <>
      <div>
        {location.state.rental && isRental()}
        <Box sx={{ flexGrow: 1 }}>
          <AppBar position="static">
            <Toolbar variant="dense">
              <Typography variant="h4" color={"inherit"} component="div">
                Modify {brandCar}
              </Typography>
            </Toolbar>
          </AppBar>
        </Box>
        {!location.state.rental && (
          <Container component={"main"} maxWidth="xs">
            <CssBaseline />
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
                variant="contained"
                type="submit"
                fullWidth
                sx={{ mt: 3, mb: 2 }}
                onClick={handleClickOpenDelete}
              >
                Delete car into list of client
              </Button>
              <Dialog open={openDelete} onClose={handleClickCloseDelete}>
                <DialogTitle>{"Delete car in way definty"}</DialogTitle>
                <DialogContent>
                  <DialogContentText>
                    Do you want delete the car in way definty. The car then will
                    not be view of 'list for rental car'
                  </DialogContentText>
                </DialogContent>
                <DialogActions>
                  <Button autoFocus onClick={handleClickCloseDelete}>
                    Disagree
                  </Button>
                  <Button
                    onClick={(event) => {
                      handleClickCloseDelete();
                      navigate("/deleteCar", {
                        state: { idCar: location.state.idCar, idWorker: location.state.idWorker },
                      });
                    }}
                  >
                    Agree
                  </Button>
                </DialogActions>
              </Dialog>
              
              <Box marginLeft={2}></Box>
              <Button
                variant="contained"
                type="submit"
                fullWidth
                sx={{ mt: 3, mb: 2 }}
                onClick={handleClickOpenVisibility}
              >
                Change visibility car
              </Button>
              <Dialog
                open={openVisibility}
                onClose={handleClickCloseVisibility}
              >
                <DialogTitle>{"Change visibility car"}</DialogTitle>
                <DialogContent>
                  <DialogContentText>
                    Do you want change the visibility car?
                  </DialogContentText>
                </DialogContent>
                <DialogActions>
                  <Button autoFocus onClick={handleClickCloseVisibility}>
                    Disagree
                  </Button>
                  <Button
                    onClick={(event) => {
                      handleClickCloseVisibility();
                      navigate("/functionChangeVisibilityCar", {
                        state: { idCar: location.state.idCar, idWorker: location.state.idWorker },
                      });
                    }}
                  >
                    Agree
                  </Button>
                </DialogActions>
              </Dialog>

              <Box margin={1}/>
              <Button
                variant="contained"
                type="submit"
                fullWidth
                sx={{ mt: 3, mb: 2 }}
                onClick={handleClickOpenChangeVisibilityCar}
              >
                Change dates available
              </Button>
              <Box marginLeft={2}></Box>
              <Dialog
                open={changeVisibilityCar}
                onClose={handleClickCloseChangeVisibilityCar}
              >
                <DialogTitle>
                  {"Change dates for the visibility car"}
                </DialogTitle>
                <DialogContent>
                  <DialogContentText>
                    Attention -- you change dates for the visibility car
                  </DialogContentText>
                </DialogContent>
                <DialogActions>
                  <Button onClick={handleClickCloseChangeVisibilityCar}>
                    Disagree
                  </Button>
                  <Button
                    onClick={(event) => {
                      handleClickOpenChangeVisibilityCar();
                      navigate("/changeDatesVisibilityCar", {
                        state: { idCar: location.state.idCar, idWorker: location.state.idWorker },
                      });
                    }}
                    autoFocus
                  >
                    Agree
                  </Button>
                </DialogActions>
              </Dialog>

            </Box>
          </Container>
        )}
      </div>
    </>
  );
}

export default ChangeVisibilityCar;

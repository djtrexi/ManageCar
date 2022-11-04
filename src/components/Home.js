import { Button } from "@mui/material";
import React from "react";
import { useNavigate } from "react-router-dom";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import { Container } from "@mui/system";

function Home() {
  const navigate = useNavigate();

  return (
    <div>
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static">
          <Toolbar variant="dense">
            <Typography
              variant="h4"
              color="inherit"
              align="center"
              component="div"
            >
              Rental car
            </Typography>
          </Toolbar>
        </AppBar>
      </Box>
      <Container component={"main"}>
        <Typography variant="h6" align="center" component={"div"}>
          Who are you?
        </Typography>
        <Box m={1} display="flex" justifyContent="center" alignItems="center">
          <Button variant="contained" onClick={() => navigate("/client")}>
            Client
          </Button>
          <React.Fragment>&nbsp;&nbsp;&nbsp;</React.Fragment>
          <Button variant="contained" onClick={() => navigate("/worker")}>
            Worker
          </Button>
        </Box>
      </Container>
    </div>
  );
}

export default Home;

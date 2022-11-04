import React from "react";
import { useNavigate } from "react-router-dom";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import { Container } from "@mui/system";
import { Button } from "@mui/material";

function HomeClient() {
  const navigate = useNavigate();

  return (
    <div>
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static">
          <Toolbar variant="dense">
            <Typography variant="h4" color="inherit" component="div">
              Welcome client
            </Typography>
          </Toolbar>
        </AppBar>
      </Box>
      <Typography variant="h6" align="center">
        What are you doing?
      </Typography>
      <Container component={"main"}>
        <Box m={1} display="flex" justifyContent="center" alignItems="center">
          <Button variant="contained" onClick={() => navigate("/loginUser")}>
            Login
          </Button>
          <React.Fragment>&nbsp;&nbsp;&nbsp;</React.Fragment>
          <Button
            align="center"
            variant="contained"
            onClick={() => navigate("/signup")}
          >
            signup
          </Button>
        </Box>
      </Container>
    </div>
  );
}

export default HomeClient;

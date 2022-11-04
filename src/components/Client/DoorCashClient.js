import React, { useEffect, useState } from "react";
import { Box, AppBar, Toolbar, Typography, Button } from "@mui/material";
import { Container } from "@mui/system";
import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";

function DoorCashClient() {
  const location = useLocation();
  const navigate = useNavigate();

  const [numberDoor, setNumberDoor] = useState("");
  
  const getAndSetNumberDoor = async() => {
    return await axios.post("http://localhost:8081/client/getIdByEmail", {
      email: location.state.email,
    }).then((response) => {
      axios.put("http://localhost:8081/client/setDoorClient", {
        id: response.data.id,
      }).then((response) => {
        setNumberDoor(response.data);
      }).catch((err) => {
        console.error(err);
      })
    }).catch((err) => {
      console.error(err);
    })
  };

  useEffect(() => {
    getAndSetNumberDoor();
  }, []);

  return (
    <div>
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static">
          <Toolbar variant="dense">
            <Typography variant="h4" color={"inherit"} component="div">
              Complete the order
            </Typography>
          </Toolbar>
        </AppBar>
      </Box>
      <Container component={"main"} maxWidth="xs">
        <Box
          sx={{
            marginTop: 8,
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
          }}
        >
          <Typography variant="subtitle1" component={"div"}>
            You must go at door number {numberDoor}
          </Typography>
          <Button
            variant="contained"
            fullWidth
            sx={{ mt: 3, mb: 2 }}
            onClick={navigate('/')}
          >
            Back to home
          </Button>
        </Box>
      </Container>
    </div>
  );
}

export default DoorCashClient;

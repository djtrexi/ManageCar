import React from 'react'
import {
    Box,
    AppBar,
    Toolbar,
    Typography,
    CssBaseline,
    Button,
  } from "@mui/material";
import { Container } from '@mui/system';
import { useNavigate } from 'react-router-dom';

function FinishOrder() {
  const navigate = useNavigate();

  return (
    <div>
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static">
          <Toolbar variant="dense">
            <Typography variant="h4" color={"inherit"} component="div">
              Order complet
            </Typography>
          </Toolbar>
        </AppBar>
      </Box>
      <Container component="main" maxWidth="xs">
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
            Thank you.
          </Typography>
          <Button
            variant="contained"
            onClick={() =>
              navigate("/rental")
            }
          >
            Go to home
          </Button>
        </Box>
      </Container>
    </div>
  )
}

export default FinishOrder;
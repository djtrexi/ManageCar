import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import {
  Button,
  AppBar,
  Checkbox,
  CssBaseline,
  FormControl,
  TextField,
  Toolbar,
  Typography,
  Box,
  Container,
  Grid
} from "@mui/material";

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleEmail = (event) => {
    setEmail(event.target.value);
  };

  const handlePassword = (event) => {
    setPassword(event.target.value);
  };

  let navigate = useNavigate();

  const handleSubmit = (event) => {
    event.preventDefault();
    axios
      .post("http://localhost:8081/client/loginClient", {
        email: email,
        password: password,
      })
      .then((response) => {
        navigate("/indexClient", { state: { email: email } });
      })
      .catch((error) => {
        console.error(error);
      });
  };
  return (
    <div>
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static">
          <Toolbar variant="dense">
            <Typography variant="h4" color={"inherit"} component="div">
              Login
            </Typography>
          </Toolbar>
        </AppBar>
      </Box>
      <Container component={"main"}>
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
            <TextField
              margin="normal"
              fullWidth
              id="email"
              label="Email Address"
              autoComplete="email"
              autoFocus
              type={"email"}
              value={email}
              onChange={handleEmail}
              required
              name="email"
            />
            <TextField
              margin="normal"
              fullWidth
              label="Password"
              type={"password"}
              value={password}
              onChange={handlePassword}
              required
              id="password"
              autoComplete="current-password"
              name="password"
            />
            <FormControl
              control={<Checkbox value={"rember"} color="primary" />}
              label="Remeber me"
            />
            <Button
              variant="contained"
              fullWidth
              sx={{ mt: 3, mb: 2 }}
              type={"submit"}
            >
              Login
            </Button>
            <Grid container justifyContent={"flex-end"}>
              <Grid item>
                <Button onClick={() => navigate('/signup')}>
                  Sign Up
                </Button>
              </Grid>
            </Grid>
            <Grid container justifyContent={"flex-end"}>
              <Grid item>
                <Button onClick={() => navigate('/client')}>
                  Back section client
                </Button>
              </Grid>
            </Grid>
            <Grid container justifyContent={"flex-end"}>
              <Grid item>
                <Button onClick={() => navigate("/")}>
                  Back to home
                </Button>
              </Grid>
            </Grid>
          </Box>
        </Box>
      </Container>
    </div>
  );
}

export default Login;

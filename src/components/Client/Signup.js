import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import {
  Button,
  CssBaseline,
  AppBar,
  TextField,
  Toolbar,
  Typography,
  Box,
  Container,
  Grid,
} from "@mui/material";

const Signup = () => {
  const [name, setName] = useState("");
  const [surname, setSurname] = useState("");
  const [email, setEmail] = useState("");
  const [phone, setPhone] = useState("");
  const [password, setPassword] = useState("");

  const handleName = (event) => {
    setName(event.target.value);
  };

  const handleSurname = (event) => {
    setSurname(event.target.value);
  };

  const handleEmail = (event) => {
    setEmail(event.target.value);
  };

  const handlePhone = (event) => {
    setPhone(event.target.value);
  };

  const handlePassword = (event) => {
    setPassword(event.target.value);
  };

  let navigate = useNavigate();

  const handleSubmit = (event) => {
    event.preventDefault();
    event.stopPropagation();
    axios
      .post("http://localhost:8081/client/signClient", {
        name: name,
        surname: surname,
        email: email,
        phone: phone,
        password: password,
      })
      .then((response) => {
        navigate("/loginUser");
      })
      .catch((err) => {
        console.error(err);
        alert("ERROR...user already sign or the dates insert are wrong");
        navigate("/signup");
      });
  };

  return (
    <div>
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static">
          <Toolbar variant="dense">
            <Typography variant="h4" color={"inherit"} component="div">
              Signup
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
            sx={{ mt: 3 }}
            onSubmit={handleSubmit}
          >
            <Grid container spacing={2}>
              <Grid item xs={12} sm={6}>
                <TextField
                  autoComplete="given-name"
                  fullWidth
                  id="name"
                  autoFocus
                  type={"text"}
                  value={name}
                  onChange={handleName}
                  required
                  label="Name"
                  name="name"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  fullWidth
                  autoComplete="family-name"
                  id="surname"
                  autoFocus
                  type={"text"}
                  value={surname}
                  onChange={handleSurname}
                  required
                  label="Surname"
                  name="surname"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  type={"email"}
                  value={email}
                  onChange={handleEmail}
                  required
                  id="email"
                  fullWidth
                  label="Email Address"
                  name="email"
                  autoComplete="email"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  autoComplete="new-phone"
                  id="phone"
                  fullWidth
                  label="Phone"
                  type={"tel"}
                  value={phone}
                  onChange={handlePhone}
                  required
                  placeholder="Insert your phone"
                  name="phone"
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  type={"password"}
                  value={password}
                  onChange={handlePassword}
                  required
                  fullWidth
                  label="Password"
                  name="password"
                  id="password"
                  autoComplete="new-password"
                />
              </Grid>
              <Button
                variant="contained"
                fullWidth
                sx={{ mt: 3, mb: 2 }}
                type={"submit"}
              >
                Signup
              </Button>
            </Grid>
            <Grid container justifyContent={"flex-end"}>
              <Grid item>
                <Button onClick={() => navigate("/loginUser")}>Login</Button>
              </Grid>
            </Grid>
            <Grid container justifyContent={"flex-end"}>
              <Grid item>
                <Button onClick={() => navigate("/client")}>
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
};

export default Signup;

import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import TextField from "@mui/material/TextField";
import { Button, Checkbox, CssBaseline, FormControl } from "@mui/material";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import { Container } from "@mui/system";

function LoginWorker() {
  const navigate = useNavigate();

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [codWorker, setCodWorker] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
    axios
      .post("http://localhost:8081/worker/loginWorker", {
        email: email,
        password: password,
        codWorker: codWorker,
      })
      .then((response) => {
        navigate("/indexWorker", { state: { email: email } });
      })
      .catch((err) => {
        console.error(err);
      });
  };

  const handleEmail = (event) => {
    setEmail(event.target.value);
  };

  const handlePassword = (event) => {
    setPassword(event.target.value);
  };

  const handleCodWorker = (event) => {
    setCodWorker(event.target.value);
  };

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
              Login
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
            onSubmit={handleSubmit}
            noValidate
            sx={{ mt: 1 }}
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
              required
              name="email"
              onChange={handleEmail}
            />
            <TextField
              margin="normal"
              fullWidth
              label="Password"
              type={"password"}
              id="password"
              autoComplete="current-password"
              value={password}
              required
              name="password"
              onChange={handlePassword}
            />
            <TextField
              margin="normal"
              fullWidth
              label="Code worker"
              id="codWorker"
              autoComplete="codWorker"
              autoFocus
              type={"text"}
              value={codWorker}
              required
              name="codWorker"
              onChange={handleCodWorker}
            />
            <FormControl
              control={<Checkbox value="remember" color="primary" />}
              label="Remeber me"
            />
            <Button
              variant="contained"
              type="submit"
              fullWidth
              sx={{ mt: 3, mb: 2 }}
            >
              Login
            </Button>
          </Box>
        </Box>
      </Container>
    </div>
  );
}

export default LoginWorker;

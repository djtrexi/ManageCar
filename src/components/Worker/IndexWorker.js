import axios from "axios";
import React, { useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import { Button } from "@mui/material";
import { Container } from "@mui/system";

function IndexWorker() {
  const location = useLocation();
  const navigate = useNavigate();

  const [name, setName] = useState("");
  const [idWorker, setIdWorker] = useState(0);
  const [totBill, setTotBill] = useState(0);
  const [totBillBoolean, setTotBillBoolean] = useState(false);

  function getName() {
    axios
      .post("http://localhost:8081/worker/getNameByEmail", {
        email: location.state.email,
      })
      .then((response) => {
        setName(response.data.name);
        axios
          .post("http://localhost:8081/worker/getIdByEmail", {
            email: location.state.email,
          })
          .then((response) => {
            setIdWorker(response.data);
          })
          .catch((err) => {
            console.error(err);
          });
      })
      .catch((err) => {
        console.error(err);
      });
  }

  const countBillForWorker = () => {
    getName();
    axios
      .post("http://localhost:8081/worker/getIdByEmail", {
        email: location.state.email,
      })
      .then((response) => {
        axios
          .post("http://localhost:8081/bill/totBillCashForDeterminedWorker", {
            id: response.data.id,
          })
          .then((response) => {
            let valueJSON = JSON.stringify(response.data);
            let parseJSON = JSON.parse(valueJSON);
            setTotBill(parseJSON.tot);
            if (totBill === 0) {
              setTotBillBoolean(false);
            } else {
              setTotBillBoolean(true);
            }
          })
          .catch((err) => {
            console.error(err);
          });
      })
      .catch((err) => {
        console.error(err);
      });
  };

  function buttonToTBill() {
    return (
      <div>
        <Button
          sx={{ mt: 2 }}
          variant="contained"
          onClick={() => navigate("/finishpayment", {state: {email: location.state.email}})}
        >
          Show bills
        </Button>
      </div>
    );
  }

  countBillForWorker();


  return (
    <div>
      
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static">
          <Toolbar variant="dense">
            <Typography variant="h4" color="inherit" component="div">
              Welcome {name}
            </Typography>
          </Toolbar>
        </AppBar>
      </Box>
      <Container component={"main"} maxWidth="xs">
        <Box sx={{ margin: 2 }}>
          <Typography variant="h6" align="center" component={"div"}>
            What do you want to do?
          </Typography>
        </Box>

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
            sx={{ mt: 2 }}
            variant="contained"
            onClick={() =>
              navigate("/addCar", {
                state: { idWorker: idWorker },
              })
            }
          >
            Add car
          </Button>
          <React.Fragment>&nbsp;&nbsp;&nbsp;</React.Fragment>
          <Button
            sx={{ mt: 2 }}
            variant="contained"
            onClick={() =>
              navigate("/allcarofworker", {
                state: { idWorker: idWorker },
              })
            }
          >
            View car manage of {name}
          </Button>
          <React.Fragment>&nbsp;&nbsp;&nbsp;</React.Fragment>
          {totBillBoolean &&   
              buttonToTBill()
            
          }
        </Box>
      </Container>
    </div>
  );
}

export default IndexWorker;

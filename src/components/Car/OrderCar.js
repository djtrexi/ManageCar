import React, { useEffect, useState } from 'react'
import {
  Grid,
  Box,
  AppBar,
  Toolbar,
  Typography,
  CssBaseline,
  FormLabel,
  FormControlLabel,
  Radio,
  RadioGroup,
  Button,
} from "@mui/material";
import { Container } from '@mui/system';
import axios from 'axios';
import { useLocation, useNavigate } from 'react-router-dom';

function OrderCar() {
  const location = useLocation();
  const navigate = useNavigate();

  const [totDifferenceDate, setTotDifferenceDate] = useState(0);
  const [totPay, setTotPay] = useState(0);
  const [typePay, setTypePay] = useState("");
  const [booleanTypePay, setBooleanTypePay] = useState(false);

  const differenceDate = async() => {
    return await axios.post("http://localhost:8081/car/countTotCarRentalByIdClient", {
      id: location.state.idCar,
    }).then((response) => {
      setTotDifferenceDate(response.data);
      axios.post("http://localhost:8081/car/moneyDailyById", {
        id: location.state.idCar,
      }).then((response) => {
        if(totDifferenceDate === 0){
          setTotPay(response.data.moneyDaily);
        }
        else{
          setTotPay(totDifferenceDate * response.data.moneyDaily);
        }
      }).catch((err) => {
        console.error(err);
      })
    }).catch((err) => {
      console.error(err);
    })
  };

  const handleTypePay = (event) => {
    setTypePay(event.target.value);
  };

  const handleSubmit = () => {
    if(typePay === "cash"){
      setBooleanTypePay(true);
    }
    else{
      setBooleanTypePay(false);
    }
    axios.post("http://localhost:8081/car/updatePayment", {
      id: location.state.idCar,
      totalMoneyRental: totPay,
      typePay: booleanTypePay,
    }).then((response) => {
      if(booleanTypePay){
        navigate("/doorCashClient", {state: { email: location.state.email }});
      }
      else{
        navigate("/finishOrder")
      }
    }).catch((err) => {
      console.error(err);
    })
  };

  useEffect(() => {
    differenceDate();
  }, [])

  return (
    <div>
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static">
          <Toolbar variant="dense">
            <Typography variant="h4" color={"inherit"} component="div">
              Payment
            </Typography>
          </Toolbar>
        </AppBar>
      </Box>
      <Container component={"main"} maxWidth="xs">
        <CssBaseline/>
        <Box
          sx={{
            marginTop: 8,
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
          }}
        >
          <Typography variant="subtitle1">
            You must pay {totPay} for the rental car
          </Typography>
          <Typography variant="subtitle1">
            Insert data for the payment
          </Typography>
          <Box
            component={"form"}
            noValidate
            sx={{ mt: 1 }}
            onSubmit={handleSubmit}
          >
            <Grid container spacing={2}>
              <Grid item xs={3}>
                <FormLabel>
                  Type of payment
                </FormLabel>
                <RadioGroup
                  name="typePay"
                  value={typePay}
                  onChange={handleTypePay}
                >
                <FormControlLabel 
                  value="cart"
                  control={<Radio />} 
                  label="Cart"
                />
                <FormControlLabel 
                  value="cash" 
                  control={<Radio />}
                  label="Cash"
                />
                </RadioGroup>
              </Grid>
              <Grid
                container
                spacing={0}
                direction="column"
                alignItems="center"
                justifyContent="center"
                style={{ minHeight: "50vh" }}
              >
                <Button
                  variant="contained"
                  fullWidth
                  sx={{ mt: 3, mb: 2 }}
                  type={"submit"}
                >
                  Send
                </Button>
              </Grid>
            </Grid>
          </Box>
        </Box>
      </Container>
    </div>
  )
}

export default OrderCar;
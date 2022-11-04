import { Alert, Button } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useLocation, useNavigate } from 'react-router-dom';

function DeleteCar() {
  const navigate = useNavigate();
  const location = useLocation();

  const [success, setSuccess] = useState(false); 

  const deleteCarDefinity = async () => {
    axios.put("http://localhost:8081/car/deleteCar", {
        id: location.state.idCar
    }).then((response) => {
        setSuccess(true);
    }).catch((err) => {
        setSuccess(false);
        console.error(err);
    })
  };

  useEffect(() => {
    deleteCarDefinity();
  }, []);
  
  return (
    <>
      <div>
        {success ? <Alert 
                      severity="success"
                      action={
                        <Button 
                          color='inherit'
                          onClick={(event) => {navigate("/allcarofworker", {
                            state: { idWorker: location.state.idWorker },
                          })
                          }}
                        >
                          Back to section car
                        </Button>
                      }
                    >
                      The car is out
                    </Alert> 
                    : 
                    <Alert 
                      severity="error"
                      action={
                        <Button
                          variant="contained"
                          onClick={() =>
                            navigate("/changeVisibilty", {
                              state: { idCar: location.state.idCar, idWorker: location.state.idWorker },
                            })
                          }
                        >
                          Back to section car
                        </Button>
                      }
                    >
                      Problem!!!!
                    </Alert>
          }
      </div>
    </>
  );
};

export default DeleteCar;
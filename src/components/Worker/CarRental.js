import React, { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function CarRental() {
  const navigate = useNavigate();

  const [loading, setLoading] = useState(true);
  const [cars, setCars] = useState([]);

  const getCar = async () => {
      return await axios
        .get("http://localhost:8081/car/viewCarRental")
        .then((response) => {
          console.log(response.data.c);
          setLoading(true);
          setCars(response.data.c);
        })
        .catch((err) => {
          console.error(err);
          setLoading(false);
          alert("ERROR 403");
        });
  };

  useEffect(() => {
    getCar();
  }, [])

  return (
    <>
      <div>
        <table>
          <thead>
            <tr>
              <th>Model</th>
              <th>Brand</th>
              <th>Color</th>
              <th>Money daily</th>
            </tr>
          </thead>
          {loading && (
            <tbody>            
              {cars.map(car => (
                <tr key={car.id}>
                  <td>
                    <div>{car.model}</div>
                  </td>
                  <td>
                    <div>{car.brand}</div>
                  </td>
                  <td>
                    <div>{car.color}</div>
                  </td>
                  <td>
                    <div>{car.moneyDaily}</div>
                  </td>
                </tr>
              ))}
            </tbody>
          )}
        </table>
      </div>
    </>
  );
}

export default CarRental;

import React, {useContext, useEffect, useState} from 'react';
import axios from "axios";
import {Link} from "@reach/router";
import MyContext from "../contexts/RefreshContext";

const ProductsList = (props) => {

    const [products, setProducts] = useState([]);
    const {refresh,setRefresh} = useContext(MyContext);

    console.log(refresh)

    useEffect(() => {

        axios.get('http://localhost:8000/api/products/')
            .then(res => {
                setProducts(res.data);
                setRefresh(false);
            })
            .catch(err => console.log(err))
    }, [refresh])


    return (
        products.map((item, index) => {
            return <h3 key={index}><Link to={'/api/product/' + item._id}>{item.title}</Link></h3>
        })
    );

};

export default ProductsList;
import React, {useContext, useEffect, useState} from 'react';
import axios from "axios";
import {Link} from "@reach/router";
import MyContext from "../contexts/RefreshContext";

const ProductsList = () => {

    const [products, setProducts] = useState([]);
    const {refresh, setRefresh} = useContext(MyContext);

    useEffect(() => {
        axios.get('http://localhost:8000/api/products/')
            .then(res => {
                setProducts(res.data);
                setRefresh(false);
            })
            .catch(err => console.log(err))
    }, [refresh])


    function handleDelete(e, id) {
        e.preventDefault();
        axios.delete(`http://localhost:8000/api/product/${id}/delete`)
            .then(setRefresh(true))
            .catch((err) => console.log(err)
            )
    }

    return (
        products.map((item, index) => {
            return (
                <div key={index+"div"} className={"d-flex align-items-center justify-content-center"}>
                    <h3 className={"p-2"} key={index}><Link to={'/api/product/' + item._id}>{item.title}</Link></h3>

                    <Link to={`/api/product/${item._id}/edit`}> Update < /Link>

                    <span className={"p-1"}>|</span>
                    <a href={"/api/product/"} onClick={
                        (e) => handleDelete(e, item._id)
                    }> Delete < /a>
                </div>
            )

        })
    );

}

export default ProductsList;
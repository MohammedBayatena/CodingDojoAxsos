import React from 'react';
import StyledBox from "./StyledBox.ja";

const ShapeDisplay = (props) => {
    const {shapes} = props;

    const createshape = (item, i) => {
        return (
            <div key={i}>
                <StyledBox bgColor={item.color} width={item.width + "px"} height={item.height + "px"}/>
            </div>
        )
    }

    return (
        <div className={"d-flex m-2 flex-wrap"}>{
            shapes.map((item, i) =>
                createshape(item, i)
            )
        }</div>
    );


};

export default ShapeDisplay;
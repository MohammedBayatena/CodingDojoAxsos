import React from 'react';

const ButtonComponent = (props) => {

    const {buttonText, successCallBack} = props;

    function handleButton(e) {
        e.preventDefault();
        successCallBack();
    }

    return (
        <button className={"btn btn-primary m-1"} onClick={handleButton}>
            {buttonText}
        </button>
    );
};

export default ButtonComponent;
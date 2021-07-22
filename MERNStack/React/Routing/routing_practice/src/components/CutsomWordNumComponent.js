import React from 'react';

const CutsomWordNumComponent = (props) => {

    function generatestyle() {
        const {bgcolor, txtcolor} = props;
        if (!(null == bgcolor && null == txtcolor)) {
            return {backgroundColor: bgcolor, color: txtcolor}
        } else if (!(null == bgcolor)) {
            return {backgroundColor: bgcolor}
        } else if (!(null == txtcolor)) {
            return {color: txtcolor}
        } else {
            return {}
        }
    }

    return (
        <div style={generatestyle()}>
            {
                isNaN(props.value) ? <h1>The Word is {props.value}</h1> : <h1> The Number is {props.value}</h1>
            }
        </div>
    )

}
export default CutsomWordNumComponent;
import styled from 'styled-components';

// This is a styled object using a styling in jsx tool
const StyledBox = styled.div`
    border: 1px solid lightgray;
    background: ${props => props.bgColor};
    width: ${props => props.width || '100px'};
    height: ${props => props.height || '100px'};
    margin: 2px;
`;

export default StyledBox;
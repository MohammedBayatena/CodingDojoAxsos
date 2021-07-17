import React, {useState} from 'react';
import styles from "./tab.module.css"
import Content from "./Content";

const Tabs = (props) => {
    const {tabs} = props; // Define a tabs array
    const [selected, setSelected] = useState("0");
    const handleSelect = (e) => {
        let id = e.target.id;
        document.getElementById(selected).setAttribute("class", styles.tab)
        document.getElementById(id).setAttribute("class", (styles.active + " " + styles.tab))
        setSelected(document.getElementById(id).id)
    }
    return (
        <div>
            {
                tabs.map(
                    (item, index) => {
                        return <button key={index} id={index} onClick={handleSelect}
                                       className={styles.tab}>{item.name}</button>
                    })
            }
            <div>
                <Content content={tabs[selected].value}/>
            </div>
        </div>
    )
};

export default Tabs;
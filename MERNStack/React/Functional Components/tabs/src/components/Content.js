import styles from "./content.module.css"

const Content = (props) => {

    const {content} = props;
    return (
        <div className={styles.content}>
            <h1>{content}</h1>
        </div>
    )
};

export default Content;
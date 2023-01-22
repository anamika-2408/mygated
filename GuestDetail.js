import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";


const GuestDetail = () => {
    const { id } = useParams();

    const [guestdata, guestdatachange] = useState({});

    useEffect(() => {
        fetch("http://localhost:8080/society/Guest/detail/" + id).then((res) => {
            return res.json();
        }).then((resp) => {
            guestdatachange(resp);
        }).catch((err) => {
            console.log(err.message);
        })
    }, []);
    return (
        <div>
            {/* <div className="row">
                <div className="offset-lg-3 col-lg-6"> */}

               <div className="container">
                
            <div className="card row" style={{ "textAlign": "left" }}>
                <div className="card-title">
                    <h2>Guest Create</h2>
                </div>
                <div className="card-body"></div>

                {guestdata &&
                    <div>
                        <h2>The Guest name is : <b>{guestdata.name}</b>  ({guestdata.id})</h2>
                        <h3>Contact Details</h3>
                        <h5>Phone is : {guestdata.phone}</h5>
                        <h5>Flat No : {guestdata.flatNo}</h5>
                        <Link className="btn btn-danger" to="/">Back to Listing</Link>
                    </div>
                }
            </div>
            </div>
            {/* </div>
            </div> */}
        </div >
    );
}

export default GuestDetail;
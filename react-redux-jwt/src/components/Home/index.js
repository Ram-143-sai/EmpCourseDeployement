import React from 'react'
import { Link } from "react-router-dom";


function Home(props) {
    return(
    <div align="center">
            <br/>
            <br/>
            <h1 align="center">Dashboard</h1>
            <br/>
            <br/>
        <div class="row" style={{align:"center"}}>
            <div class="col-sm-5" >
            <div class="card">
            <div class="card-body">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDCdigt0T9UORvKwVJdKgMw4D_t2uJg5pOLw&usqp=CAU" class="img-fluid rounded-start" alt="loading"></img>
                <hr/>
            <div>
            <Link
                    className="btn btn-primary mx-2"
                    to={`availableCourses/${props.id}`}
                  >
                    Available Courses
                  </Link>
            </div>
            </div>
            </div>
            </div>
            <div class="col-sm-5">
            <div class="card" >
            <div class="card-body">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVMmBt-Mndy0Y1Zm0Rl2lpW_sVyq8P1t-0OQ&usqp=CAU" class="img-fluid rounded-start" alt="loading"></img>
            <hr/>
            <div>
            <Link
                    className="btn btn-primary mx-2"
                    to={`enrolledCourses/${props.id}`}
                  >
                    Registered Courses
                  </Link>
            </div>
            </div>
            </div>
            </div>
        </div>
    </div>
    );
}
export default Home
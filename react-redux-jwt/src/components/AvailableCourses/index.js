import React, { Component } from "react";
import { Redirect } from 'react-router-dom';
import { connect } from "react-redux";

// import AllItems from '../AllItems'
import UserService from '../../services/auth.service';



class Training extends Component {
    
    constructor(props){
        
        super(props)
        this.state = {
            id:'',
            products:[]
        }
    }
    
    componentDidMount(){
        const { user: currentUser } = this.props;
        console.log(currentUser.id);
        UserService.getAvailableCoursesForEmp(currentUser.id).then((response) => {
            this.setState({ products: response.data})
        });

    }
    openInNewTab=(content)=>{
        window.open(content, '_blank', 'noopener,noreferrer');
      };
      saveOrUpdateProduct = (empId,courseId) => {
        
        let product = {empId,courseId};
        // console.log('product => ' + JSON.stringify(product));

    
            UserService.addProduct(product).then(res =>{
                console.log(product);
            });
       
    }
      
  render (){
    const { user: currentUser } = this.props;

    if (!currentUser) {
      return <Redirect to="/login" />;
    }
    const { products} = this.state
    

  return (
            <div>
                <h1 align="center">Available Courses</h1>
            

          <div className="courses"  style={{display:'flex',flexDirection:'column'}}>
            <div className="row "  style={{display:'flex',flexDirection:'row'}}>
                    {
                        products.map(({courseId,courseName,content,imageUrl,instructor}) => {
                          
                           
                            return (
                                <div    style={{height:'320',margin:'1cm',width:'300px'}}  className="card col-lg-4 col-xl-3 col-md-6  mb-3" key={courseId}>
                                    <img style={{height:'4cm',width:'100%',padding:'0.2cm'}}                      src={imageUrl}  alt="Sorry! Image is not available at this time"/>
                                    <hr/>
                                    <div className="content">
                                        <h5 align="center">{ courseName }</h5>
                                        <p align="center">{ instructor }</p>
                                    </div>
                                    <div align="center"><button  className="btn btn-primary" onClick={() => this.saveOrUpdateProduct(currentUser.id,courseId)}>
                                        Enroll Now
                                        </button>
                                    </div>
                                </div>

                            );
                        })
                    }
                </div>
                </div>

            </div>
         )
        }
}
function mapStateToProps(state) {
    const { user } = state.auth;
    return {
      user,
    };
  }
  
  export default connect(mapStateToProps)(Training);
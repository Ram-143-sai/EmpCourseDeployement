import React from 'react'
import {Component} from 'react'


// import AllItems from '../AllItems'
import UserService from '../../Services/UserService';

class Training extends Component {

    constructor(props){
        super(props)
        this.state = {
            Id :'',
            products:[]
        }
    }
    
    componentDidMount(){

        UserService.getProducts().then((response) => {
            this.setState({ products: response.data})
        });

    }
    openInNewTab=(content)=>{
        window.open(content, '_blank', 'noopener,noreferrer');
      };
  render (){
    const { products} = this.state
    

  return (
            <div>
                <h1 align="center">All Courses</h1>
            

          <div className="courses"  style={{display:'flex',flexDirection:'column'}}>
            <div className="row "  style={{display:'flex',flexDirection:'row'}}>
                    {
                        products.map(({courseId,courseName,content,imageUrl,instructor}) => {
                          
                           
                            return (
                                <div    style={{height:'300px',margin:'1cm',width:'300px'}}  className="card col-lg-4 col-xl-3 col-md-6  mb-3" key={courseId}>
                                    <img  onClick={() => this.openInNewTab(content)} style={{height:'4cm',width:'100%',padding:'0.2cm'}}                      src={imageUrl}  alt="Sorry! Image is not available at this time"/>
                                    <hr/>
                                    <div className="content">
                                        <h5>{ courseName }</h5>
                                        <p>{ instructor }</p>
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

export default Training
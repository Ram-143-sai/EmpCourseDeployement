import axios from "axios";

const API_URL = "http://localhost:8080/api/auth/";

class AuthService {
  login(username, password) {
    return axios
      .post(API_URL + "signin", { username, password })
      .then((response) => {
        if (response.data.accessToken) {
          localStorage.setItem("user", JSON.stringify(response.data));
        }

        return response.data;
      });
  }

  logout() {
    localStorage.removeItem("user");
  }
  getAvailableCoursesForEmp(id){
    return axios.get(API_URL +`availableCourses/${id}`);
  } 
  getEnrolledCoursesForEmp(id){
    return axios.get(API_URL +`enrolledCourses/${id}`);
  } 
  addProduct(product){
    return axios.post(API_URL +`enrollCourse`,product);
  } 
  register(username, email, designationLevel,password) {
    return axios.post(API_URL + "signup", {
      username,
      email,
      designationLevel,
      password,
    });
  }
}

export default new AuthService();

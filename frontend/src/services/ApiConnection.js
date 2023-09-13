import axios from 'axios'

const urlCourse = "http://localhost:8080/Courses"
const urlUser = "http://localhost:8080/users"


class ApiConnection{
    async getAllCourses() {
        try {
            let response = await axios.get(urlCourse);
            return response
        } catch (error) {
            return (error.message)
        }
    }

    async getCourseById(id) {
        try {
            let response = await axios.get(`${urlCourse}/${id}`)
            return response
        } catch (error) {
            return (error.message)
        }
    }

    async deleteCourseById(id) {
        try {
            let response = await axios.delete(`${urlCourse}/${id}`)
            return response
        } catch (error) {
            return (error.message)
        }
    }

    
}

export default new ApiConnection;
import axios from 'axios'

const urlCourse = "http://localhost:8080/courses"
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

    async addCourse(course) {
        try {
            let response = await axios.post(urlCourse, course)
            return response
        } catch (error) {
            return (error.message)
        }
    }

    async updateCourse(id, course) {
        try {
            let response = await axios.put(`${urlCourse}/update/${id}`, course)
            return response
        } catch (error) {
            return (error.message)
        }
    }

    async getAllUsers() {
        try {
            let response = await axios.get(urlUser);
            return response
        } catch (error) {
            return (error.message)
        }
    }

    async getUserById(id) {
        try {
            let response = await axios.get(`${urlUser}/${id}`)
            return response
        } catch (error) {
            return (error.message)
        }
    }

    async deleteUserById(id) {
        try {
            let response = await axios.delete(`${urlUser}/${id}`)
            return response
        } catch (error) {
            return (error.message)
        }
    }

    async addUser(user) {
        try {
            let response = await axios.post(user)
            return response
        } catch (error) {
            return (error.message)
        }
    }

    async updateUser(id, user) {
        try {
            let response = await axios.put(`${urlUser}/${id}`, user)
            return response
        } catch (error) {
            return (error.message)
        }
    }
}

export default new ApiConnection;
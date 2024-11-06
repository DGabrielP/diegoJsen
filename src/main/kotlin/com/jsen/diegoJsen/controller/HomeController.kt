package com.jsen.diegoJsen.controller

import com.jsen.diegoJsen.model.Model
import com.jsen.diegoJsen.response.ErrorResponse
import com.jsen.diegoJsen.response.SuccessResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/home")
class HomeController {

    @GetMapping()
    fun home(@RequestBody model: Model): SuccessResponse {

        return SuccessResponse().apply{
            status = "success"
            data = model
        }
    }

    @GetMapping("/failed")
    fun getModel(@RequestBody model: Model): SuccessResponse {

        return SuccessResponse().apply{
            status = "failed"
            data = "Hay un error y no es mi culpa"
        }
    }

    @GetMapping("/error")
    fun errorModel(@RequestBody model: Model): ErrorResponse {

        return ErrorResponse().apply{
            status = "error"
            message = "Unable to communicate with database"
        }
    }


}
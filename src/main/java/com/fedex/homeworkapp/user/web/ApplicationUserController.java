package com.fedex.homeworkapp.user.web;


import com.fedex.homeworkapp.user.utility.ListUserNamesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.fedex.homeworkapp.user.exceptions.UserRoleNotFoundException;
import com.fedex.homeworkapp.user.utility.ErrorResponse;
import com.fedex.homeworkapp.user.exceptions.RegistrationAttemptException;
import com.fedex.homeworkapp.user.utility.ApplicationUserDTO;
import com.fedex.homeworkapp.user.service.ApplicationUserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class ApplicationUserController {

    private ApplicationUserService applicationUserService;

    @Autowired
    public ApplicationUserController(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody @Valid ApplicationUserDTO applicationUserDTO)
            throws MethodArgumentNotValidException, RegistrationAttemptException, UserRoleNotFoundException {
        applicationUserService.registerApplicationUser(applicationUserDTO);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public ListUserNamesDTO getAllUsernames() {
        ListUserNamesDTO listUserNamesDTO = new ListUserNamesDTO();
        listUserNamesDTO.setUserNames(applicationUserService.findAllUsernames());
        return listUserNamesDTO;
    }

    @ResponseBody
    @ExceptionHandler(RegistrationAttemptException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    ErrorResponse registrationattemptHandler(RegistrationAttemptException ex) {
        return new ErrorResponse(ex.getMessage());
    }


    @ResponseBody
    @ExceptionHandler(UserRoleNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse userRoleNotFoundHandler(UserRoleNotFoundException ex) {
        return new ErrorResponse(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    ErrorResponse userRoleNotFoundHandler(AccessDeniedException ex) {
        return new ErrorResponse(ex.getMessage());
    }
}

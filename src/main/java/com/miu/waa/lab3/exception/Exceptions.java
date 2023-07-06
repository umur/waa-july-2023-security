package com.miu.waa.lab3.exception;

import org.springframework.http.HttpStatus;

public class Exceptions {
        public static final ServiceException BAD_CREDENTIAL_EXCEPTION = new ServiceException(HttpStatus.UNAUTHORIZED,
                        "SS001", "Bad credentials.");
        public static final ServiceException INVALID_SIGNUP_PASSWORDS = new ServiceException(HttpStatus.BAD_REQUEST,
                        "SS002", "Passwords must be same.");
        public static final ServiceException ROLE_NOT_FOUND = new ServiceException(HttpStatus.NOT_FOUND,
                        "SS003", "Role is not found.");
        public static final ServiceException INVALID_TOKEN = new ServiceException(HttpStatus.UNAUTHORIZED,
                        "SS004", "Invalid token.");
        public static final ServiceException AUTH_NOT_FOUND = new ServiceException(HttpStatus.UNAUTHORIZED,
                        "SS005", "Auth is not found.");
        public static final ServiceException USER_NOT_FOUND = new ServiceException(HttpStatus.UNAUTHORIZED,
                        "SS006", "User is not found.");
        public static final ServiceException WORD_EXCEED = new ServiceException(HttpStatus.BAD_REQUEST,
                        "SS007", "Max Bad Words Requests Limit has been Reached. You need wait for %minutes% minutes.");
}

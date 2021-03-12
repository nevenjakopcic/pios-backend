package hr.tvz.pios.scheduler.controller;

import hr.tvz.pios.scheduler.config.JwtTokenUtil;
import hr.tvz.pios.scheduler.dto.ApiResponse;
import hr.tvz.pios.scheduler.model.JwtRequest;
import hr.tvz.pios.scheduler.model.JwtResponse;
import hr.tvz.pios.scheduler.service.JwtUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
        try {
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            final String token = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new ApiResponse(new JwtResponse(token)));
        }
        catch (DisabledException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                .body(new ApiResponse("This user is disabled."));
        }
        catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                .body(new ApiResponse("Incorrect username and/or password."));
        }
    }

    private void authenticate(String username, String password) throws DisabledException, BadCredentialsException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}

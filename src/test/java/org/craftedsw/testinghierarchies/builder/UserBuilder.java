package org.craftedsw.testinghierarchies.builder;

import org.craftedsw.testinghierarchies.domain.User;

public class UserBuilder {
    private boolean prime;

    public static UserBuilder aUser() {
        return new UserBuilder();
    }

    public UserBuilder prime(boolean prime) {
        this.prime = prime;
        return this;
    }

    public User build() {
        User user = new User();
        user.setPrime(prime);
        return user;
    }
}

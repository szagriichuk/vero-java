package com.vero.java.api;

import com.vero.java.api.params.*;

/**
 * The Users end-point. This end-point allows you to add or update a user (subscriber) to your
 * Vero database. You must record an identifier (ID) to add a user to your database and you
 * must also record an email in order to actually email that customer.
 * You are also able to store additional user attributes for use in your various email campaigns.
 * These are typically values like first_name, last_name, age, etc.
 *
 * @author szagriichuk.
 */
public interface UsersApi {
    /**
     * The {@code add} method allows you to add subscribers and their attributes to your Vero database.
     * In this example we add a user with the identifier (a Vero system field) {@code 1234} and
     * email address {@code john@smith.com} and store the properties {@code firstname} and {@code lastname}
     * with values John and Smith respectively.
     * <pre>
     * {@code usersApi.add(new Id(1234), new Email("john@smith.com"), new UserData(new VeroData<String>(){{
     *     add(new FirstName("John"));
     *     add(new FirstName("Smith"));
     * }}));
     * }
     * </pre>
     */
    void add(Id id, Email email, UserData data);

    /**
     * The {@code update} allows you to update a subscriber’s attributes in your Vero database.
     * <pre>
     * {@code usersApi.update(new Id(1234), new Changes(new VeroData<String>(){{
     * add(new FirstName("Mark"));
     * add(new LastName("Twain"));
     * }}));
     * }
     * </pre>
     */
    void update(Id id, Changes data);

    /**
     * The {@code reidentify} allows you to reidentify (alias) a user. This enables you to change the ID of a user.
     * <pre>
     * {@code
     * usersApi.reidentify(new Id(1234), new NewId(4321));
     * }
     * </pre>
     */
    void reidentify(Id id, NewId newId);

    void editTags(Id id, Add add, Remove remove);
}

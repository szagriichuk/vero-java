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
     */
    void add(Id id, Email email, UserData data);

    /**
     * The {@code update} allows you to update a subscriber’s attributes in your Vero database.
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

    /**
     * The {@code editTags} allows you to {@code add} or/and {@code remove} tags.
     * <pre>
     *     {@code
     *     usersApi.editTags(new Id(1234), new AddTag("warm-lead"), new RemoveTag("prospect"));
     *     }
     * </pre>
     */
    void editTags(Id id, Tag... tags);

    /**
     * The {@code unsubscribe} gives you a simple way to unsubscribe a user.
     * <p/>
     * To unsubscribe a user, simply pass up the identifier (ID) of the user
     * you want to unsubscribe.
     */
    void unsubscribe(Id id);

    /**
     * The {@code resubscribe} endpoint gives you a simple way to resubscribe a user.
     * To resubscribe a user, simply pass up the identifier (ID) of the user
     * you want to resubscribe.
     */
    void resubscribe(Id id);

    /**
     * The {@code delete} endpoint gives you a simple way to delete a user from Vero DB.
     */
    void delete(Id id);


}

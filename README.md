# Command Line Commands

--- 

> * Note that HTTpie should be available on the command line to be able to run the below commands:

--- 

### Getting a user with the specified 'userId'
```bash
    http :8080/users/b3fbff59-ba7a-4928-a12f-a8f7f22623ae
```

### Deleting a user with the specified 'userId'
```bash
    http DELETE :8080/users/b094c07d-a220-4c24-9f4b-8095d8f08491
```

### Updating a user with the specified 'userId'
```bash
    http PUT :8080/users/b094c07d-a220-4c24-9f4b-8095d8f08491 < update_user.json
```

### Creating a user
```bash
    http POST :8080/users < create_user.json
```


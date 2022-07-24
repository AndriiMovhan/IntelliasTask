CREATE TABLE IF NOT EXISTS public.user_good(
    user_id INTEGER REFERENCES users(user_id),
    good_id INTEGER REFERENCES good(good_id),
    primary key (user_id, good_id)
    );
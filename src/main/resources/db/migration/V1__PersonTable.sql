  CREATE TABLE person (
      id UUID NOT NULL PRIMARY KEY,
      name VARCHAR(70) NOT NULL
  );

  ALTER TABLE person
  ADD COLUMN IF NOT EXIST phone VARCHAR(50);

  ALTER TABLE person
  ADD COLUMN IF NOT EXIST address VARCHAR(150);
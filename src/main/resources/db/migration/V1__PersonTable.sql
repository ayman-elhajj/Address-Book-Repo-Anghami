  CREATE EXTENSION "uuid-ossp";

  CREATE TABLE person (
      id UUID NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
      name VARCHAR(70) NOT NULL,
      phone VARCHAR(50),
      address VARCHAR(150),
      seq_id SERIAL
  );


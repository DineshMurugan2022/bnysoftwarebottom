-- V8__create_team_member.sql

CREATE TABLE team_member (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    bio TEXT,
    image VARCHAR(255),
    display_order INT,
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)
);

INSERT INTO team_member (name, role, bio, image, display_order) VALUES
('Babu', 'CEO & Founder', 'Former VP of Engineering with 15+ years of enterprise software experience.', '/babu.jpg', 1),
('Mani', 'CTO & Co-Founder', 'Architect of scalable cloud systems handling millions of daily transactions.', '/mani.jpg', 2),
('Dinesh', 'Lead Designer', 'Award-winning UX designer obsessed with creating frictionless digital experiences.', '/dinesh.jpg', 3),
('Alice Johnson', 'Head of Engineering', 'Open source contributor and AI enthusiast leading our machine learning initiatives.', '/images/team/designer.png', 4);

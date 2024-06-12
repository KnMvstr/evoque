-- Create a sequence for artist assignments
--CREATE SEQUENCE artist_seq START 1;--

-- Insertion des catégories
INSERT INTO category (title, description) VALUES
                                              ('Opening', 'A mesmerizing launch for new artists and their visionary collections.'),
                                              ('Education', 'Tailored experiences for academic exploration and learning.'),
                                              ('Exhibition', 'Exclusive displays of unique and breathtaking art collections.'),
                                              ('VIP', 'Elite gatherings, performances, and corporate events in a sophisticated setting.'),
                                              ('Daily', 'All-access day pass to the museum’s regular exhibits and rooms.');

-- Insertion des artistes
--CREATE TEMP TABLE artist_names (id SERIAL PRIMARY KEY, name VARCHAR(255));--
INSERT INTO artist_names (name) VALUES
                                    ('Yayoi Kusama'), ('David Hockney'), ('Jeff Koons'), ('Ai Weiwei'), ('Kara Walker'),
                                    ('Takashi Murakami'), ('Cindy Sherman'), ('Anish Kapoor'), ('Olafur Eliasson'), ('Damien Hirst'),
                                    ('Marina Abramović'), ('Gerhard Richter'), ('Tracey Emin'), ('Kehinde Wiley'), ('Banksy'),
                                    ('Jenny Holzer'), ('Richard Serra'), ('Bruce Nauman'), ('Louise Bourgeois'), ('Ellsworth Kelly'),
                                    ('Chris Ofili'), ('Julie Mehretu'), ('Wangechi Mutu'), ('Theaster Gates'), ('Nick Cave'),
                                    ('Rashid Johnson'), ('Njideka Akunyili Crosby'), ('David Hammons'), ('Kerry James Marshall'), ('Fred Wilson'),
                                    ('Glenn Ligon'), ('Mark Bradford'), ('Titus Kaphar'), ('Mickalene Thomas'), ('Lorna Simpson'),
                                    ('Isaac Julien'), ('Julian Schnabel'), ('George Condo'), ('Nan Goldin'), ('Gillian Wearing'),
                                    ('Tacita Dean'), ('Shirin Neshat'), ('Steve McQueen'), ('Rachel Whiteread'), ('Wolfgang Tillmans'),
                                    ('Thomas Demand'), ('Ragnar Kjartansson'), ('Cecily Brown'), ('Yinka Shonibare'), ('Isa Genzken'),
                                    ('Pipilotti Rist'), ('Ann Hamilton'), ('Matthew Barney'), ('Pieter Hugo'), ('Hito Steyerl'),
                                    ('Doris Salcedo'), ('Danh Vo'), ('Pierre Huyghe'), ('Lynette Yiadom-Boakye'), ('Alicja Kwade'),
                                    ('Mark Leckey'), ('Elmgreen & Dragset'), ('Rirkrit Tiravanija'), ('Sarah Lucas'), ('Antony Gormley'),
                                    ('Doug Aitken'), ('Doug Wheeler'), ('Larry Bell'), ('Marlene Dumas'), ('William Kentridge'),
                                    ('Ghada Amer'), ('Kiki Smith'), ('Jenny Saville'), ('Tschabalala Self'), ('Sterling Ruby'),
                                    ('Yto Barrada'), ('Rachel Harrison'), ('Michael Rakowitz'), ('Adrian Piper'), ('Cao Fei'),
                                    ('Do Ho Suh'), ('Xu Bing'), ('Taryn Simon'), ('Trevor Paglen'), ('Anicka Yi'),
                                    ('Cameron Rowland'), ('Hank Willis Thomas'), ('Simon Denny'), ('Adrian Villar Rojas'), ('Tino Sehgal'),
                                    ('Darren Bader'), ('Jordan Wolfson'), ('David Shrigley'), ('Ryan Trecartin'), ('Liz Magor'),
                                    ('Joan Jonas'), ('David Altmejd'), ('Ryan Gander'), ('Lara Favaretto'), ('Kris Martin'),
                                    ('Simon Starling'), ('Kader Attia'), ('Simon Fujiwara'), ('Andreas Gursky'), ('Rineke Dijkstra'),
                                    ('Jeff Wall'), ('Tavares Strachan'), ('Christo'), ('Emeka Ogboh'), ('Shahzia Sikander'),
                                    ('Kahlil Joseph'), ('Otobong Nkanga'), ('Kendell Geers'), ('Robin Rhode'), ('Pascale Marthine Tayou'),
                                    ('Lubaina Himid'), ('El Anatsui'), ('Victor Ehikhamenor'), ('Zanele Muholi'), ('Candice Breitz'),
                                    ('Titus Kaphar'), ('Charles Gaines'), ('Melvin Edwards'), ('Renee Cox'), ('Lyle Ashton Harris'),
                                    ('Derrick Adams'), ('Sanford Biggers'), ('Shinique Smith'), ('David Hammons'), ('Stan Douglas'),
                                    ('Julius von Bismarck'), ('Philippe Parreno'), ('Tacita Dean'), ('Cao Fei'), ('Cecily Brown'),
                                    ('John Currin'), ('Lisa Yuskavage'), ('George Condo'), ('Albert Oehlen'), ('Wolfgang Tillmans'),
                                    ('Erwin Wurm'), ('Tavares Strachan'), ('Sarah Sze'), ('Nick Cave'), ('Lynette Yiadom-Boakye'),
                                    ('Wangechi Mutu'), ('Theaster Gates'), ('Njideka Akunyili Crosby'), ('David Hammons'), ('Fred Wilson'),
                                    ('Glenn Ligon'), ('Isaac Julien'), ('Julian Schnabel'), ('George Condo'), ('Nan Goldin');

-- Insertion des titres
--CREATE TEMP TABLE event_titles (category_id INT, title VARCHAR(255));--
INSERT INTO event_titles (category_id, title) VALUES
                                                  (1, 'Grand Opening with'), (1, 'Inauguration Ceremony featuring'), (1, 'Opening Night with'), (1, 'Exclusive Launch Event:'),
                                                  (1, 'Artistic Opening by'), (2, 'Educational Workshop by'), (2, 'Art Class with'), (2, 'Lecture on Art by'),
                                                  (2, 'Masterclass with'), (2, 'Interactive Session with'), (3, 'Exhibition: Masterpieces of'), (3, 'Exclusive Collection of'),
                                                  (3, 'Art Showcase by'), (3, 'Exhibit by'), (3, 'Gallery Showing of'), (4, 'VIP Experience with'),
                                                  (4, 'Exclusive VIP Event: Featuring'), (4, 'VIP Gala with'), (4, 'Special VIP Night with'), (4, 'Elite VIP Gathering: Featuring'),
                                                  (5, 'Daily Museum Tour: Highlighting'), (5, 'Museum Day Pass: Explore'), (5, 'Daily Highlights: Featuring'),
                                                  (5, 'Museum Experience with'), (5, 'Daily Special: Discover');

-- Insertion des descriptions
--CREATE TEMP TABLE event_descriptions (category_id INT, description VARCHAR(255));--
INSERT INTO event_descriptions (category_id, description) VALUES
                                                              (1, 'Celebrate the grand opening with showcasing their visionary collections.'),
                                                              (1, 'Join the inauguration ceremony and experience the artworks of.'),
                                                              (1, 'Opening night special with the incredible works of.'),
                                                              (1, 'Exclusive launch event featuring the creations of.'),
                                                              (1, 'Artistic opening night with.'),
                                                              (2, 'Join our educational workshop to explore the techniques and history of.'),
                                                              (2, 'Art class led by the renowned.'),
                                                              (2, 'Insightful lecture on art by.'),
                                                              (2, 'Masterclass in art with.'),
                                                              (2, 'Interactive session with.'),
                                                              (3, 'Discover exclusive works by in this unique exhibition.'),
                                                              (3, 'An exclusive collection of masterpieces by.'),
                                                              (3, 'Art showcase featuring the works of.'),
                                                              (3, 'Exhibit showcasing the art of.'),
                                                              (3, 'Gallery showing of the amazing works of.'),
                                                              (4, 'Enjoy an exclusive VIP experience with including live art, music, and dance.'),
                                                              (4, 'Exclusive VIP event featuring.'),
                                                              (4, 'VIP gala night with special guest.'),
                                                              (4, 'Special VIP night featuring.'),
                                                              (4, 'Elite VIP gathering with the art of.'),
                                                              (5, 'Experience the museum with a day pass and enjoy special features on.'),
                                                              (5, 'Museum day pass to explore the works of.'),
                                                              (5, 'Daily highlights featuring the art of.'),
                                                              (5, 'Museum experience with special exhibits on.'),
                                                              (5, 'Daily special event to discover the art of.');

-- Calcul des prix
WITH Prices AS (
    SELECT 18 AS dailyPricePerHour, 11 AS dailyHours, 18 * 11 AS dailyTotalPrice
),
     Date_Generator AS (
         SELECT generate_series(DATE '2024-01-01', DATE '2024-12-31', INTERVAL '1 day') AS event_date
     ),
     Event_Times AS (
         SELECT
             category_id,
             start_time + (random() * (end_time - start_time - interval '2 hours') + interval '1 hour') AS start_time
         FROM (
                  VALUES
                      (1, '16:00'::interval, '23:00'::interval),
                      (2, '08:00'::interval, '12:00'::interval),
                      (3, '08:00'::interval, '18:00'::interval),
                      (4, '14:00'::interval, '23:00'::interval),
                      (5, '08:00'::interval, '19:00'::interval)
              ) AS t(category_id, start_time, end_time)
     ),
     Unique_Events AS (
         SELECT
             cat.id AS category_id,
             ROW_NUMBER() OVER (PARTITION BY cat.id ORDER BY RANDOM()) AS row_num,
             dg.event_date
         FROM
             Date_Generator dg
                 CROSS JOIN
             category cat
     )
-- Insertion des événements
INSERT INTO event (title, description, start_time, end_time, price, available_qtty, category_id)
SELECT
    t.title || ' ' || a.name,
    d.description || ' ' || a.name,
    dg.event_date + et.start_time,
    dg.event_date + et.start_time + interval '2 hours',
    CASE
        WHEN cat.id = 1 THEN pr.dailyTotalPrice * 1.1
        WHEN cat.id = 2 THEN pr.dailyPricePerHour * 0.25 * 6
        WHEN cat.id = 3 THEN pr.dailyTotalPrice
        WHEN cat.id = 4 THEN pr.dailyTotalPrice * 1.1
        WHEN cat.id = 5 THEN pr.dailyTotalPrice
        END,
    CASE
        WHEN cat.id = 5 THEN 5000
        ELSE FLOOR(RANDOM() * (100 - 25 + 1) + 25)
        END,
    cat.id
FROM category cat
         CROSS JOIN Unique_Events dg
         CROSS JOIN Event_Times et
         CROSS JOIN Prices pr
         LEFT JOIN LATERAL (
    SELECT *,
           ROW_NUMBER() OVER (PARTITION BY cat.id ORDER BY RANDOM()) AS artist_row_num,
           cat.id AS category_id -- Adding category_id from the category table alias cat
    FROM artist_names
    ) AS a ON a.artist_row_num = dg.row_num AND cat.id = a.category_id
         CROSS JOIN LATERAL (SELECT title FROM event_titles WHERE category_id = cat.id ORDER BY RANDOM() LIMIT 1) t
         CROSS JOIN LATERAL (SELECT description FROM event_descriptions WHERE category_id = cat.id ORDER BY RANDOM() LIMIT 1) d
WHERE
    cat.id IN (1, 3, 4, 5) AND
    cat.id = et.category_id AND
    dg.row_num = 1
ORDER BY dg.event_date, cat.id;
